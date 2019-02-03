package com.joongang.sbtest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Sbtest01Application {

    @RestController
    private static class HelloController {

        @GetMapping("/hello")
        public String hello() {
            return "Hello World";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Sbtest01Application.class, args);
    }

}

