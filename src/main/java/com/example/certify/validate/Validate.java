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
//        String regex =  "[+]\\d{1}[234][0–9]\\d{11}";
//         String regex2 = "([234][0–9]\\d{11})";
//          String regex3 =  "([07]|[08]|[09][0|1][0–9]\\d{11})";

//        if (phoneNumber.matches(regex) || phoneNumber.matches(regex2) || phoneNumber.matches(regex3))
//            return true;
        String regex = "((^+)(234)(70|80|90|81|71|91)[0-9]{10})";
        return phoneNumber.matches(regex);
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

