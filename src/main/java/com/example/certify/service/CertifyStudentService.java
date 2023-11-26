package com.example.certify.service;

import com.example.certify.dtos.request.UploadCertificateRequest;
import com.example.certify.exception.CertifyException;
import com.example.certify.mapper.Mapper;
import com.example.certify.model.Certificate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CertifyStudentService implements StudentService{

    private final CertifyAdminService certifyAdminService;

    @Override
    public Certificate upload(UploadCertificateRequest certificateRequest) throws CertifyException {
        Certificate certificate = Mapper.mapper(certificateRequest);
        return certifyAdminService.saveCertificate(certificate, certificateRequest.getStudentId());
    }
}
