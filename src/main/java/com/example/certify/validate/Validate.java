package com.example.certify.validate;


import com.example.certify.repository.StudentRepository;
import com.example.certify.service.AdminService;
import com.example.certify.service.CertifyAdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class Validate {


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



}

