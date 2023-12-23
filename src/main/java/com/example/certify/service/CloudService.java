package com.example.certify.service;

import com.example.certify.exception.CertifyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CloudService {
    String upload(MultipartFile multipartFile) throws CertifyException;
}
