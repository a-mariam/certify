package com.example.certify.service;

import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.dtos.response.ValidateStudentUploadRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.exception.FilesException;
import com.example.certify.mapper.Mapper;
import com.example.certify.model.Certificate;
import com.example.certify.model.Student;
import com.example.certify.repository.StudentRepository;
import com.example.certify.validate.Validate;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.mock.web.MockMultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class CertifyStudentService implements StudentService{

    private final CertifyAdminService certifyAdminService;
    private final StudentRepository studentRepository;
    private final Validate validate;
    private final CertifyCloudService certifyCloudService;

    @Override
    public Student student(RegisterStudentRequest request) throws CertifyException {
        if (certifyAdminService.checkIfStudentWithPhoneNumberExist(request.getPhoneNumber())) throw new CertifyException("Student with this number already exist");
        Student student = Mapper.mapper(request);
        return studentRepository.save(student);
    }

    @Override
    public Certificate   upload(UploadCertificateRequest certificateRequest) throws CertifyException {
        ValidateStudentUploadRequest response = validate.validateUploadRequest(certificateRequest);
//        certifyCloudService.upload(convertToMultipartFiles(certificateRequest.getFileUrl()));
        Certificate certificate = Mapper.mapper(certificateRequest, response);
        return certifyAdminService.saveCertificate(certificate, Long.valueOf(certificateRequest.getStudentId()));
    }

    private MultipartFile convertToMultipartFiles(String fileUrl) throws FilesException {
        Path path = Path.of(fileUrl);
        try (var inputStream = Files.newInputStream(path)){

//          MockMultiPartFiles files = new MockMultiPartFiles("files-image", inputStream);
        } catch (Exception e) {
            throw new FilesException(e.getMessage());
        }

        return null;
    }
}
