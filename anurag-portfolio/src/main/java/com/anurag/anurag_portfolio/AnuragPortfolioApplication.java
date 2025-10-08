package com.anurag.anurag_portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AnuragPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnuragPortfolioApplication.class, args);
	}

}
