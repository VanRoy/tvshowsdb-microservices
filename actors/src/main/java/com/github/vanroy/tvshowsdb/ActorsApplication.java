package com.github.vanroy.tvshowsdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ActorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActorsApplication.class, args);
    }
}
