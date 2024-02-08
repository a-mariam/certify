package com.example.certify.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {

    @Value("$api_key")
    private String cloudApiKey;
    @Value("$cloud_name")
    private String cloudName;
    @Value("$api_secret")
    private String cloudSecretKey;

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "api_key" , cloudApiKey,
                "cloud_name", cloudName,
                "api_secret", cloudSecretKey,
                "secure", "true"
        ));
    }
}
