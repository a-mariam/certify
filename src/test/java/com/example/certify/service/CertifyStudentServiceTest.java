package com.example.certify.service;

import com.example.certify.dtos.request.RegisterStudentRequest;
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
    public void testThatStudent_CanRegister() throws CertifyException {
        RegisterStudentRequest request = new RegisterStudentRequest();
        request.setEmail("mariam@gmail.com");
        request.setPassword("pasww");
        request.setFirstName("mariam");
        request.setSecondName("ambali");
        request.setPhoneNumber("08014063892");
        Student student  = studentService.student(request);
        assertNotNull(student);
    }
    @Test
    public void testThatAnotherStudent_CanRegister() throws CertifyException {
        RegisterStudentRequest request = new RegisterStudentRequest();
        request.setEmail("hannah@gmail.com");
        request.setPassword("paw");
        request.setFirstName("hannah");
        request.setSecondName("joe");
        request.setPhoneNumber("07044063892");
        Student student  = studentService.student(request);
        assertNotNull(student);
    }
    @Test
    public void testThat_AnException_IsThrown_WhenUser_TryToRegisterWith_AlreadyRegistered_Email(){
        RegisterStudentRequest request = new RegisterStudentRequest();
        request.setEmail("mariam@gmail.com");
        request.setPassword("pasww");
        request.setFirstName("mariam");
        request.setSecondName("ambali");
        request.setPhoneNumber("09044063892");

        RegisterStudentRequest request1 = new RegisterStudentRequest();
        request1.setEmail("hannah@gmail.com");
        request1.setPassword("paw");
        request1.setFirstName("hannah");
        request1.setSecondName("joe");
        request1.setPhoneNumber("07044063892");
        assertThrows(CertifyException.class, ()-> studentService.student(request));
        assertThrows(CertifyException.class, ()-> studentService.student(request1));
    }


    @Test
    public void testThat_StudentCanUpload() throws CertifyException {
        Student foundStudent = appAdminService.findStudentByPhoneNumber("07044063892");

        UploadCertificateRequest upload = new UploadCertificateRequest();
        upload.setDescription("C:\\Users\\mariam\\IdeaProjects\\Certify\\src\\main\\resources\\image\\SULWE-Netflix-movie-jpg.webp");
        upload.setDescription("still working on it");
        upload.setStudentId(foundStudent.getId().toString());
        upload.setSchoolId("1");
        Certificate certificate = studentService.upload(upload);
        Student foundStudentAfter = appAdminService.findStudentByPhoneNumber("07044063892");
        assertNotNull(certificate);
        assertEquals(1,foundStudentAfter.getCertificates().size());
    }
    @Test
    public void testThat_StudentCanRequestForCertificateVerification(){

    }


}