package com.dumb.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by guayu on 7/28/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SampleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleServiceApplication.class, args);
    }
}
