package com.db.postgreeSQL;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Log
@SpringBootApplication
public class PostgreeSqlApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public PostgreeSqlApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(PostgreeSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Datasouce: " + dataSource.toString());

		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
