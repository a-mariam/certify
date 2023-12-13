package com.example.certify.service;

import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.Certificate;
import com.example.certify.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student student(RegisterStudentRequest request) throws  CertifyException;

    Certificate upload(UploadCertificateRequest certificateRequest) throws CertifyException;
}
