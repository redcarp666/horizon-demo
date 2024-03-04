package org.redcarp.horizon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SystemApplication.class);
		app.run(args);
	}


}