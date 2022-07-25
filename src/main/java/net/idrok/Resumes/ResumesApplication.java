package net.idrok.Resumes;

import net.idrok.Resumes.entity.Education;
import net.idrok.Resumes.entity.User;
import net.idrok.Resumes.repository.EducationRepository;
import net.idrok.Resumes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class ResumesApplication implements ApplicationRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ResumesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//	User user = new User();
//	user.setUserName("admin");
//	user.setPassword(passwordEncoder.encode("123"));
//	userRepository.save(user);

	}
}
