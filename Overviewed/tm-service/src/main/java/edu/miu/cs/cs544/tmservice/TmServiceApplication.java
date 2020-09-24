package edu.miu.cs.cs544.tmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmServiceApplication.class, args);
    }

}
