package org.redcarp.horizon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author redcarp
 * @date 2024/3/13
 */
@SpringBootApplication
public class TestApplication {
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(TestApplication.class);
		sp.run(args);
	}
}
