package com.boston.OutdoorsApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileDataService {
    String uploadFile(MultipartFile file) throws IOException;

    byte[] downloadFile(String fileName) throws IOException;
}
