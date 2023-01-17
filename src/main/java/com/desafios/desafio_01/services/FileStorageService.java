package com.desafios.desafio_01.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
	private final Path fileStorageLocation;

	//@Autowired
	public FileStorageService(Environment env) {
		this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-dir", "./uploads/files")).toAbsolutePath()
				.normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}

	public String getFileExtension(String fileName) {
		if (fileName == null) {
			return null;
		}
		String[] fileNameParts = fileName.split("\\.");

		return fileNameParts[fileNameParts.length - 1];
	}

	public String storeFile(MultipartFile file, String extension) {
		// Normalize file name
		
		System.out.println("fl:"+extension);
		
		String fileName = new Date().getTime() + "-arquivo." + extension;
		return fileName;
		
/*
		try {
			// Check if the filename contains invalid characters
			if (fileName.contains("..")) {
				throw new RuntimeException("O nome do arquivo contém uma sequência de caminho inválida " + fileName);
			}

			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return fileName;
		} catch (IOException ex) {
			System.out.println("Não foi possível armazenar o arquivo " + fileName + ". Por favor, tente novamente!");
			throw new RuntimeException("Não foi possível armazenar o arquivo " + fileName + ". Por favor, tente novamente!", ex);
		} */
	}
}
