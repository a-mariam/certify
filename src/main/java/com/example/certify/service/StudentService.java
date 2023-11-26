package com.example.certify.service;

import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.model.Certificate;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Certificate upload(UploadCertificateRequest certificateRequest) throws CertifyException;
}
