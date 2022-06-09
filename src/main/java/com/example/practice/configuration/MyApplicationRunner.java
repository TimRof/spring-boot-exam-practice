package com.example.practice.configuration;

import com.example.practice.model.entity.Role;
import com.example.practice.model.entity.User;
import com.example.practice.repository.RoleRepository;
import com.example.practice.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner
{
    RoleRepository roleRepository;
    UserRepository userRepository;

    public MyApplicationRunner(RoleRepository roleRepository, UserRepository userRepository)
    {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Role userRole = new Role(1, "User");
        Role adminRole = new Role(2, "Admin");

        roleRepository.saveAll(List.of(userRole, adminRole));

        User user = new User(1, "Mr.", "User", "user@gmail.com", "Secret123!", List.of(userRole));
        User admin = new User(1, "Mr.", "Admin", "admin@gmail.com", "Secret123!", List.of(userRole, adminRole));

        userRepository.saveAll(List.of(user, admin));
    }
}
