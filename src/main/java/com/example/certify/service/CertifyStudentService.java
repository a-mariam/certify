package com.example.certify.service;

import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.mapper.Mapper;
import com.example.certify.model.Certificate;
import com.example.certify.model.Student;
import com.example.certify.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CertifyStudentService implements StudentService{

    private final CertifyAdminService certifyAdminService;
    private final StudentRepository studentRepository;

    @Override
    public Student student(RegisterStudentRequest request) throws CertifyException {
        if (certifyAdminService.checkIfStudentWithPhoneNumberExist(request.getPhoneNumber())) throw new CertifyException("Student already exist");
        Student student = Mapper.mapper(request);
        return studentRepository.save(student);
    }

    @Override
    public Certificate upload(UploadCertificateRequest certificateRequest) throws CertifyException {
        Certificate certificate = Mapper.mapper(certificateRequest);
        return certifyAdminService.saveCertificate(certificate, certificateRequest.getStudentId());
    }
}
