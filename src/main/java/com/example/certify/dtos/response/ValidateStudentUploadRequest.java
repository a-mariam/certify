package com.example.certify.dtos.response;


import com.example.certify.model.School;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ValidateStudentUploadRequest {

    private Long studentId;
    private School school;
}
