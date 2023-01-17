package com.desafios.desafio_01.storage;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public class StorageService {

	void init() {
	}

	public static void store(MultipartFile file) {
	}

	Stream<Path> loadAll() {
		return null;
	}

	Path load(String filename) {
		return null;
	}

	Resource loadAsResource(String filename) {
		return null;
	}

	void deleteAll() {
	}
}
