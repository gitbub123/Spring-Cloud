package com.hgz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author LuoWei
 * @Date 2019/12/2
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class HystrixturbineApplication {
    public static void main(String[] args){
        SpringApplication.run(HystrixturbineApplication.class, args);
    }
}
