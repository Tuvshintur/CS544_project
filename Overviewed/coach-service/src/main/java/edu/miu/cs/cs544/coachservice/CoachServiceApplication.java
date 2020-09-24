package edu.miu.cs.cs544.coachservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CoachServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachServiceApplication.class, args);
	}

}
