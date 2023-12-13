package com.example.certify.repository;

import com.example.certify.model.Category;
import com.example.certify.model.School;
import com.example.certify.model.Type;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PublicUniversities {


    private static Map<String, String> map ;
    @Autowired
    private SchoolRepository schoolRepository;
    private static void initial(){

    }
    public PublicUniversities(Map<String, String> map) {
        PublicUniversities.map = map;
    }

    @PostConstruct
    public void PopulateSchool(){
        map.put("University OF LAGOS", "6190");
        School school = new School();
        school.setCEEB("6190");
        school.setPassword("password");
        school.setName("University OF LAGOS");
        school.setEmail("unilag@gmail.com");
        school.setCategory(Category.UNIVERSITY);
        school.setType(Type.PUBLIC);
        schoolRepository.save(school);
    }

    public static void add(String key, String value){
        map.put(key, value);
    }
    public static boolean contains(String key, String value ){
        var response = map.containsKey(key);
        var object = map.get(key);
        System.out.println(object);
        if (object == null) return false;
       if (!response)
           return object.equalsIgnoreCase(value);
       return false;
    }

    public static boolean containValue(String value) {
        return map.containsValue(value);
    }
    public static boolean containKey(String key) {
        System.out.println(map);
        return map.containsKey(key);
    }
}
