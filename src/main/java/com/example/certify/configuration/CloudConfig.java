package com.example.certify.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {

    @Value("$cloud_api_key")
    private String cloudApiKey;
    @Value("$Cloud_name")
    private String cloudName;
    @Value("$cloud_secret_key")
    private String cloudSecretKey;

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "api" , cloudApiKey,
                "name", cloudName,
                "secret_key", cloudSecretKey,
                "secure", "true"
        ));
    }
}
