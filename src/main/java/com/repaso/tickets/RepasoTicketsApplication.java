package com.repaso.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RepasoTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepasoTicketsApplication.class, args);
	}

}
