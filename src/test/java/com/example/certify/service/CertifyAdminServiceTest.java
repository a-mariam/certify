package com.example.certify.service;

import com.example.certify.dtos.request.RegisterSchoolRequest;
import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.School;
import com.example.certify.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CertifyAdminServiceTest {

    @Autowired
    private CertifyAdminService appAdminService;



    @Test
    public  void registerSchool(){

        RegisterSchoolRequest request = new RegisterSchoolRequest();
        request.setName("university of lagos");
        request.setSchoolCode("6190");
        request.setPassword("mamma");
        request.setEmail("unilag@gmail.com");
        School registered = appAdminService.registerSchool(request);
        assertNotNull(registered);
        assertNotNull(registered.getId());
    }
}
