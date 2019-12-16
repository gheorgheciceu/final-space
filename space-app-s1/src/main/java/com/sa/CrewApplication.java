package com.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = "com.sa"/*, exclude = {HibernateJpaAutoConfiguration.class}*/)
@EnableDiscoveryClient
public class CrewApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrewApplication.class, args);
    }

}
