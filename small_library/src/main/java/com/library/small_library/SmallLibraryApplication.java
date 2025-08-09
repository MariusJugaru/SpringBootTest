package com.library.small_library;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class SmallLibraryApplication implements CommandLineRunner {

	private LibraryInterface libraryInterface;

	public SmallLibraryApplication(LibraryInterface libraryInterface) {
		this.libraryInterface = libraryInterface;
	}

	public static void main(String[] args) {
		SpringApplication.run(SmallLibraryApplication.class, args);
	}

	public void run(final String... args) {
		log.info(libraryInterface.printBook());
	}
}
