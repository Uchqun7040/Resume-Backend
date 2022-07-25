package net.idrok.Resumes.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.idrok.Resumes.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.jwtExpirationInMs}")
    private long jwtExpirationInMs;

    @Value("${jwt.token.jwtExpirationInMsRememberMe}")
    private long jwtExpirationInMsRememberMe;

    @Autowired
    UserDetailsService userDetailsService;

    public String createToken(UserDetails userDetails,boolean rememberMe){
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.put("roles",roles.stream().map(GrantedAuthority::getAuthority).toArray());
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (rememberMe ? jwtExpirationInMsRememberMe : jwtExpirationInMs)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        if (claimsJws.getBody().getExpiration().before(new Date(System.currentTimeMillis()))){
            return false;
        }
        return true;

    }

    public String resolveToken(HttpServletRequest request){
        String bearer = request.getHeader("Authorization");
        if (bearer != null && bearer.startsWith("Bearer ")){
            return bearer.substring(7);
        }
        return null;
    }

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public Authentication getAuthenticate(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUser(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }

    private String getUser(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
}
