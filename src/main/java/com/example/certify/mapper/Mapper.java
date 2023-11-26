package com.example.certify.mapper;

import com.example.certify.dtos.request.RegisterSchoolRequest;
import com.example.certify.dtos.request.RegisterStudentRequest;
import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.model.Certificate;
import com.example.certify.model.School;
import com.example.certify.model.Student;

public class Mapper {
    public static Student mapper(RegisterStudentRequest request) {
          Student student = new Student();
          student.setEmail(request.getEmail());
          student.setPassword(request.getPassword());
          student.setFirstName(request.getFirstName());
          student.setLastName(request.getSecondName());
          student.setPhoneNumber(request.getPhoneNumber());
        return student;
    }

    public static Certificate mapper(UploadCertificateRequest certificateRequest) {
        Certificate certificate = new Certificate();
        certificate.setDescription(certificateRequest.getDescription());
        certificate.setFileUrl(certificate.getFileUrl());
        certificate.setStudentId(certificate.getStudentId());
        return certificate;
    }

    public static School mapper(RegisterSchoolRequest request) {
        School school = new School();
        school.setName(request.getName());
        school.setInstitutionId(request.getInstitutionId());
        school.setPassword(request.getPassword());
        school.setEmail(request.getEmail());
        return school;
    }
}
