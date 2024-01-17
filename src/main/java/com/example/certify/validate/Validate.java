package com.example.certify.validate;


import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.dtos.response.ValidateStudentUploadRequest;
import com.example.certify.exception.SchoolDoesNotExist;
import com.example.certify.exception.StudentException;
import com.example.certify.exception.UnknownStudent;
import com.example.certify.model.School;
import com.example.certify.model.Student;
import com.example.certify.repository.SchoolRepository;
import com.example.certify.repository.StudentRepository;
import com.example.certify.service.AdminService;
import com.example.certify.service.CertifyAdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class Validate {

    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;

    public static boolean checkIfEmailIsValid(String  email){
     String regex =  "[a-zA-Z+][0-9*][@]{1}[gmail.com]";

     return true;
    }
    public static boolean checkIfPhoneNumberIsValid(String phoneNumber){
        String regex =  "([+]{1}[234]{1}[0–9]{10})|([234][0–9]{10})|([0]{1}[7|8|9]{1}[0|1]{1}[0–9]{8})";
        String re = "[0][8|9|7}{1}[0-9]{8}";
        String reg = "[[0][7|8|9]{1}[0|1]{1}[0-9]{8}]";
//        return regex.matches(email);
//
        return true;
    }


    public ValidateStudentUploadRequest validateUploadRequest(UploadCertificateRequest certificateRequest) throws SchoolDoesNotExist, StudentException {
        Optional<Student> student = studentRepository.findById(Long.valueOf(certificateRequest.getStudentId()));
        Optional<School> school = schoolRepository.findById(Long.valueOf(certificateRequest.getSchoolId()));
        if (student.isPresent()) {
            if (school.isPresent())
                return new ValidateStudentUploadRequest(student.get().getId(), school.get());
            throw new SchoolDoesNotExist("school with id " + certificateRequest.getSchoolId() + " does not exist");
        }else {throw new StudentException("student with id " + certificateRequest.getStudentId() + " does not exit");}

    }
}

