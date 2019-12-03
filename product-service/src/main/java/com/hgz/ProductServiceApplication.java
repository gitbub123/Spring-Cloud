package com.hgz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LuoWei
 * @Date 2019/12/1
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(ProductServiceApplication.class,args);
    }
}
