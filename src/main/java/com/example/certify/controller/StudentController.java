package com.example.certify.controller;

import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.Student;
import com.example.certify.service.CertifyStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;


@RequestMapping
@AllArgsConstructor
@RestController
public class StudentController {


    private final CertifyStudentService certifyStudentService;
    @PostMapping("/api/v1/register/")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterStudentRequest request){
        System.out.println("Using sout to sout");
        Student response = null;
        try {
            response = certifyStudentService.student(request);
        } catch (CertifyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(CREATED).body(response);
    }


}
