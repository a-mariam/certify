package com.example.certify.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadCertificateRequest {

    private  String fileUrl;
    private  String description;
    private  Long studentId;
}
