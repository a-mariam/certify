package com.example.certify.service;

import com.example.certify.dtos.request.RegisterSchoolRequest;
import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.Certificate;
import com.example.certify.model.School;
import com.example.certify.model.Student;
import org.springframework.stereotype.Service;

import java.security.cert.CertificateException;

@Service
public interface AdminService {
    Student registerStudent(RegisterStudentRequest request) throws CertificateException, CertifyException;
    boolean checkIfStudentWithPhoneNumberExist(String phoneNumber);

    Student findStudentByPhoneNumber(String number) throws CertifyException;

    Certificate saveCertificate(Certificate certificate, Long studentId) throws CertifyException;

    School registerSchool(RegisterSchoolRequest request);
}
