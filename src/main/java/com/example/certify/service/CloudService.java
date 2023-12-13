package com.example.certify.service;

import com.example.certify.exception.CertifyException;
import org.springframework.stereotype.Service;

@Service
public interface CloudService {
    String upload(String file) throws CertifyException;
}
