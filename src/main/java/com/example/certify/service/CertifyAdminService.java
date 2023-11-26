package com.example.certify.service;

import com.example.certify.dtos.request.RegisterSchoolRequest;
import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.mapper.Mapper;
import com.example.certify.model.Certificate;
import com.example.certify.model.School;
import com.example.certify.model.Student;
import com.example.certify.repository.CertificateRepository;
import com.example.certify.repository.SchoolRepository;
import com.example.certify.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CertifyAdminService implements AdminService {

    private final StudentRepository studentRepository;
    private final CertificateRepository certificateRepository;
    private final SchoolRepository schoolRepository;
    @Override
    public Student registerStudent(RegisterStudentRequest request) throws CertifyException {
        if (checkIfStudentWithPhoneNumberExist(request.getPhoneNumber())) throw new CertifyException("Student already exist");
        Student student = Mapper.mapper(request);
        return studentRepository.save(student);
    }

    @Override
    public boolean checkIfStudentWithPhoneNumberExist(String phoneNumber) {
        System.out.println("student already here "+studentRepository.findByPhoneNumber(phoneNumber));
        return studentRepository.findByPhoneNumber(phoneNumber).isPresent();
    }

    @Override
    public Student findStudentByPhoneNumber(String number) throws CertifyException {
        return studentRepository.findByPhoneNumber(number).orElseThrow(() -> new CertifyException("Student with this number does not exist") );
    }

    private Student findStudentById(Long studentId) throws CertifyException {
        return studentRepository.findById(studentId).orElseThrow(() -> new CertifyException("student does not exist"));
    }

    @Override
    public Certificate saveCertificate(Certificate certificate, Long studentId) throws CertifyException {
        Student foundStudent = findStudentById(studentId);
        foundStudent.setCertificate(certificate);
        Certificate savedCertificate = certificateRepository.save(certificate);
        studentRepository.save(foundStudent);
        return savedCertificate;
    }

    @Override
    public School registerSchool(RegisterSchoolRequest request) {
        School school = Mapper.mapper(request);
        School savedSchool =   schoolRepository.save(school);
        return null;
    }


}
