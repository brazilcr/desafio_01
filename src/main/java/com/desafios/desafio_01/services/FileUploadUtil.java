package com.desafios.desafio_01.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
    public static String saveFile(String fileName, MultipartFile multipartFile, String extension)
            throws IOException {
        Path uploadPath = Paths.get("uploads/files");
          
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
 
        String fileCode = RandomStringUtils.randomAlphanumeric(8)+ "-fn."+extension;
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            //Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
        	Path filePath = uploadPath.resolve( fileCode );
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("não slavou arquivo: " + fileName, ioe);
        }
         
        return fileCode;
    }
}
