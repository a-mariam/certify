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
    public void testThatStudent_CanRegister() throws CertifyException {
        RegisterStudentRequest request = new RegisterStudentRequest();
        request.setEmail("mariam@gmail.com");
        request.setPassword("pasww");
        request.setFirstName("mariam");
        request.setSecondName("ambali");
        request.setPhoneNumber("09044063892");
        Student student  = appAdminService.registerStudent(request);
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
        Student student  = appAdminService.registerStudent(request);
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
        assertThrows(CertifyException.class, ()-> appAdminService.registerStudent(request));
        assertThrows(CertifyException.class, ()-> appAdminService.registerStudent(request1));
    }

    @Test
    public  void registerSchool(){

        RegisterSchoolRequest request = new RegisterSchoolRequest();
        request.setName("university of lagos");
        request.setSchoolCode("6190");
        request.setSchoolCode("Regs16363");
        request.setPassword("mamma");
        request.setEmail("unilag@gmail.com");
        School registered = appAdminService.registerSchool(request);
        assertNotNull(registered);
        assertNotNull(registered.getId());
    }
}
