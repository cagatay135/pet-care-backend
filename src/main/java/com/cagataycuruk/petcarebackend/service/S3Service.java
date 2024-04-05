package com.cagataycuruk.petcarebackend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Log4j2
public class S3Service {
    private AmazonS3 s3client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public S3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + file.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());

        s3client.putObject(bucketName, fileName, file.getInputStream(), metadata);

        return this.getFilePath(fileName);
    }

    public String getFilePath(String fileName) {
        return s3client.getUrl(bucketName, fileName).toString();
    }

    public void deleteFile(String fileName) {
        s3client.deleteObject(bucketName, fileName);
    }
}