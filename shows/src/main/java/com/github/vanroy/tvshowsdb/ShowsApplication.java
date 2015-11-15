package com.github.vanroy.tvshowsdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShowsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowsApplication.class, args);
    }
}
