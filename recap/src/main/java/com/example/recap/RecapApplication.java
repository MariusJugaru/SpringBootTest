package com.example.recap;

import com.example.recap.services.ColorPrinter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecapApplication implements CommandLineRunner {

	private final ColorPrinter colorPrinter;

	public RecapApplication(ColorPrinter colorPrinter) {
		this.colorPrinter = colorPrinter;
	}

	public static void main(String[] args) {
		SpringApplication.run(RecapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		colorPrinter.print();
	}
}
