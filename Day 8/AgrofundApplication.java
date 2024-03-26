package com.java.agrofund;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.java.agrofund.Enum.Role;
import com.java.agrofund.model.UserModel;
import com.java.agrofund.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AgrofundApplication {
	private final PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AgrofundApplication.class, args);
	}
	
	@SuppressWarnings("null")
	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			if(userRepository.count() > 0) return;
			var admin = UserModel.builder()
						.name("Nikitha")
						.email("Nikitha123@gmail.com")
						.password(passwordEncoder.encode("Nikitha@123"))
						.role(Role.admin)
						.build();
			userRepository.save(admin);
		};
	}

}
