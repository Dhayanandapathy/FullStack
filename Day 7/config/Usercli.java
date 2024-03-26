package com.java.agrofund.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.java.agrofund.Enum.Role;
import com.java.agrofund.model.UserModel;
import com.java.agrofund.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Usercli implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0) {
            return;
        }
        var admin = UserModel.builder()
                .name("Admin")
                .email("admin@gmail.com")
                .password("Admin@123")
                .role(Role.admin)
                .build();
        userRepository.save(admin);
    }

}