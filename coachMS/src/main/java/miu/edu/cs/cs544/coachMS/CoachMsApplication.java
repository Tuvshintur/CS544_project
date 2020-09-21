package miu.edu.cs.cs544.coachMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoachMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachMsApplication.class, args);
	}

}
