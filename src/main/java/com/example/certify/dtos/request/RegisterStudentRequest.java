package com.example.certify.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class RegisterStudentRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;
    @NotNull
    private String phoneNumber;
}
