package org.patika.onlineshopdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OnlineshopDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineshopDiscoveryApplication.class, args);
    }

}
