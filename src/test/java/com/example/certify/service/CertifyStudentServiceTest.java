package com.example.certify.service;

import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.Certificate;
import com.example.certify.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CertifyStudentServiceTest {


    @Autowired
    private CertifyAdminService appAdminService;
    @Autowired
    private CertifyStudentService studentService;



    @Test
    public void testThat_StudentCanUpload() throws CertifyException {
        Student foundStudent = appAdminService.findStudentByPhoneNumber("09044063892");

        UploadCertificateRequest upload = new UploadCertificateRequest();
        upload.setDescription("C:\\Users\\mariam\\IdeaProjects\\Certify\\src\\main\\resources\\image\\SULWE-Netflix-movie-jpg.webp");
        upload.setDescription("still working on it");
        upload.setStudentId(foundStudent.getId());
        Certificate certificate = studentService.upload(upload);
        Student foundStudentAfter = appAdminService.findStudentByPhoneNumber("09044063892");

        assertNotNull(certificate);
        assertEquals(1,foundStudentAfter.getCertificates().size());
    }
    @Test
    public void testThat_StudentCanRequestForCertificateVerification(){

    }


}