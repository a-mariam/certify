package com.example.certify.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.certify.exception.CertifyException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class CertifyCloudService implements CloudService{

    private final Cloudinary cloudinary;


    @Override
    public String upload(String file) throws CertifyException {
        MultipartFile multipartFile =  convertToMultipartFile(file);

        try {
            Map<?,?> uploadResponse = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap(
                    "resource_type", "image"
            ));
            String secureUrl = (String) uploadResponse.get("secure_url");
            log.info("upload response {} " + uploadResponse);
            return secureUrl;
        } catch (Exception e) {
          throw  new CertifyException("error occur while uploading");
        }
    }

    private MultipartFile convertToMultipartFile(String file) throws CertifyException {
        Path path = Path.of(file);
       try(InputStream inputStream = Files.newInputStream(path)){
           return new MockMultipartFile();
       }catch (Exception e){
           throw new CertifyException("error occur while converting file");
       }
    }
}
