package com.example.certify.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublicUniversitiesTest
{

    @Test
    public void validateSchools(){
//        university of lagos ", "6190"
//        assertTrue(PublicUniversities.containValue("6190"));
        assertTrue(PublicUniversities.containKey( "University OF LAGOS"));
        assertTrue(PublicUniversities.contains("University OF LAGOS", "6190"));

    }
}