package com.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.sa")
@EnableDiscoveryClient
public class PlanetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanetApplication.class, args);
    }

}
