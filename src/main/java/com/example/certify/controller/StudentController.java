package com.example.certify.controller;

import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.Student;
import com.example.certify.service.CertifyAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateException;

import static org.springframework.http.HttpStatus.CREATED;


@RequestMapping
@AllArgsConstructor
public class StudentController {


    private final CertifyAdminService certifyAdminService;
    @PostMapping("/api/v1/register/student")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterStudentRequest request){
        System.out.println("Using sout to sout");
        Student response = null;
        try {
            response = certifyAdminService.registerStudent(request);
        } catch (CertifyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(CREATED).body(response);
    }


}
