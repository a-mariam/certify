package com.example.certify.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.certify.exception.CertifyException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class CertifyCloudService implements CloudService{

    private final Cloudinary cloudinary;


    @Override
    public String upload(MultipartFile multipartFile) throws CertifyException {

        try {
            Map<?,?> uploadResponse = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap(
                    "resource_type", "image"
            ));
            String secureUrl = (String) uploadResponse.get("secure_url");
            log.info("upload response {} " + uploadResponse);
            return secureUrl;
        } catch (Exception e) {
          throw  new CertifyException(e.getMessage());
        }
    }

   }

