package com.example.certify.service;

import com.example.certify.model.Category;
import com.example.certify.model.School;
import com.example.certify.model.Type;
import com.example.certify.repository.SchoolRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CertifySchoolService implements SchoolService{

    private SchoolRepository schoolRepository;
    @Override
    @PostConstruct
    public void populateDatabase() {
        School school = new School();
        school.setCEEB("6190");
        school.setPassword("password");
        school.setName("University OF LAGOS");
        school.setEmail("unilag@gmail.com");
        school.setCategory(Category.UNIVERSITY);
        school.setType(Type.PUBLIC);
        schoolRepository.save(school);
    }
}
