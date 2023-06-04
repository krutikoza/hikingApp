package com.boston.OutdoorsApi.service.impl;

import com.boston.OutdoorsApi.Models.FileData;
import com.boston.OutdoorsApi.dao.FileDataRepository;
import com.boston.OutdoorsApi.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    private FileDataRepository fileDataRepository;

    @Value("${dataPath}")
    private String FOLDER_PATH;

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public String uploadFile(MultipartFile file) throws IOException {
        String filepath = FOLDER_PATH+file.getOriginalFilename();

        FileData fileData = new FileData();

        fileData.setName(file.getOriginalFilename());
        fileData.setType(file.getContentType());
        fileData.setFilePath(filepath);

        fileDataRepository.save(fileData);

        file.transferTo(new File(filepath));

        return null;

    }

    public byte[] downloadFile(String fileName) throws IOException{
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);


        String filePath = fileData.get().getFilePath();

        byte[] file = Files.readAllBytes(new File(filePath).toPath());

        return file;

    }


}
