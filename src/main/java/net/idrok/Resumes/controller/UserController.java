package net.idrok.Resumes.controller;

import net.idrok.Resumes.entity.User;
import net.idrok.Resumes.security.JwtTokenProvider;
import net.idrok.Resumes.security.Token;
import net.idrok.Resumes.security.UserProvider;
import net.idrok.Resumes.security.UserSpecial;
import net.idrok.Resumes.service.UserService;
import net.idrok.Resumes.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/user")

public class UserController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @Autowired
    UserProvider userProvider;



    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserSpecial userSpecial)
            throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userSpecial.getUsername(), userSpecial.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        UserDetails userDetails = userProvider.loadUserByUsername(userSpecial.getUsername());
        String token = jwtTokenProvider.createToken(userDetails,userSpecial.isRememberMe());
        return ResponseEntity.ok(new Token(token));
    }


    @GetMapping
    public List<UserDTO> getAll(){
    return userService.getAll();

    }

      @PostMapping("/register")
      public ResponseEntity<UserDTO> register(@RequestBody User user) {
      if (user.getId() != null)
        return ResponseEntity.badRequest().build();
      return ResponseEntity.ok(userService.create(user));
      }

}
