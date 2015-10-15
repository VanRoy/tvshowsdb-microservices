package com.github.vanroy.tvshowsdb;

import com.github.vanroy.cloud.dashboard.config.EnableCloudDashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableCloudDashboard
public class SupervisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupervisorApplication.class, args);
    }
}
