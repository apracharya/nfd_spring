package com.teamfilm.nfd.service.film;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileServiceImplementation implements FileService{
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // File name
        String name = file.getOriginalFilename();

        // random name generation
        String randomId = UUID.randomUUID().toString();
        String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));

        // full path
        String filePath = path + File.separator + fileName1;

        // create folder
        File f = new File(path);
        if(!f.exists()) {
            f.mkdir();
        }

        // file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName1;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream inputStream = new FileInputStream(fullPath);

        return inputStream;
    }
}
