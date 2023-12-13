package com.example.certify.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class config {


    @Bean
    public Map<String, String> university(){

        return new HashMap<>();
    }
}
