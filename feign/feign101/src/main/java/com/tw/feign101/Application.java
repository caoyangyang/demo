package com.tw.feign101;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients(basePackages = {"com.tw.feign101.client"})
@SpringBootApplication(scanBasePackages = "com.tw")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
