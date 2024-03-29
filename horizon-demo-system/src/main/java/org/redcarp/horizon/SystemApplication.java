package org.redcarp.horizon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SystemApplication.class);
		app.run(args);
	}


}
