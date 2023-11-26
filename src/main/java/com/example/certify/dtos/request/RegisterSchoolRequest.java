package com.example.certify.dtos.request;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class RegisterSchoolRequest {
    private String schoolCode;
    private String name;
    private String email;
    private String password;
    private String category;
    private String type;
}
