package com.edu.miu.cs544.tminstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TMinstructorMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TMinstructorMsApplication.class, args);
	}

}
