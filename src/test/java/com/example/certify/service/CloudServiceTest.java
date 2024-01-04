package com.example.certify.service;

import com.example.certify.exception.CertifyException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CloudServiceTest {

    @Autowired
    private CloudService cloudService;

    private final String IMAGE_LOCATION = "C:\\Users\\mariam\\IdeaProjects\\Certify\\src\\main\\resources\\image\\SULWE-Netflix-movie-jpg.webp";

    @Test
    public void testUploadImage() throws CertifyException, IOException {
        String response = cloudService.upload(getTestFile(IMAGE_LOCATION));
        assertNotNull(response);
    }

    private MultipartFile getTestFile(String imageLocation){
        Path path = Path.of(imageLocation);
        try(var inputStream = Files.newInputStream(path)){
            MultipartFile file = new MockMultipartFile(path.getFileName().toString(),inputStream);
            return file;
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

