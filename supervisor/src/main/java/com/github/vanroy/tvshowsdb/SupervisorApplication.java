package com.github.vanroy.tvshowsdb;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
@EnableAdminServer
public class SupervisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupervisorApplication.class, args);
    }
}
