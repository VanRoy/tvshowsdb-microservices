package com.github.vanroy.tvshowsdb;

import com.github.vanroy.tvshowsdb.event.Changes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Changes.class)
public class ActorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActorsApplication.class, args);
    }
}
