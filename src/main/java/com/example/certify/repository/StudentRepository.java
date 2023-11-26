package com.example.certify.repository;

import com.example.certify.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByPhoneNumber(String phoneNumber);
    Optional<Student> findById(Long studentId);
}
