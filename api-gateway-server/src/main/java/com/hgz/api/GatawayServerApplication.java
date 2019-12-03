package com.hgz.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LuoWei
 * @Date 2019/12/3
 */
@SpringBootApplication
@EnableEurekaClient
public class GatawayServerApplication {
    public static void main(String[] args){
        SpringApplication.run(GatawayServerApplication.class, args);
    }
}
