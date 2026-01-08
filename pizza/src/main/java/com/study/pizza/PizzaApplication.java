package com.study.pizza;

import com.study.pizza.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class PizzaApplication implements CommandLineRunner {

	private final PizzaConfig pizzaConfig;

	public PizzaApplication(PizzaConfig pizzaConfig) {
		this.pizzaConfig = pizzaConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(
				String.format("I want a pizza with %s sauce, for toppings %s and %s crust",
						pizzaConfig.getSauce(),
						pizzaConfig.getTopping(),
						pizzaConfig.getCrust())
		);

	}
}
