package com.teamfilm.mynfd.service.film;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileServiceImplementation implements FileService{
/* // Paila ko implementation
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
*/

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }

        String originalName = StringUtils.cleanPath(file.getOriginalFilename());

        if (originalName.contains("..")) {
            throw new IOException("Invalid path sequence in file name: " + originalName);
        }

        // Get the file extension (like .jpg, .png)
        String extension = originalName.substring(originalName.lastIndexOf("."));

        // Generate a unique filename
        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(extension);

        // Full path
        Path uploadPath = Paths.get(path);
        Files.createDirectories(uploadPath); // creates folder if not exists
        Path filePath = uploadPath.resolve(fileName);

        // Copy the file to the target location
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName; // <--- this should return the complete filename!
    }

/* // paila ko implementation
    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream inputStream = new FileInputStream(fullPath);

        return inputStream;
    }
*/

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        if (fileName.contains("..")) {
            throw new SecurityException("Invalid file path");
        }

        String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        return new FileInputStream(file);
    }

}
