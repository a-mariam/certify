package com.example.certify.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStudentRequest {
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private String phoneNumber;
}
