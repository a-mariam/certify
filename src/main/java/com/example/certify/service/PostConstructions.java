package com.example.certify.service;

import com.example.certify.model.Admin;
import com.example.certify.repository.AdminRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostConstructions {


    private final AdminRepository adminRepository;
    @PostConstruct
    private void createAdmin(){
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setPassword("Mariam@@1");
        adminRepository.save(admin);
    }
}
