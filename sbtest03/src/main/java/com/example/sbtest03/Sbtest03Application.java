package com.example.sbtest03;

import com.example.sbtest03.model.Product;
import com.example.sbtest03.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sbtest03Application {
    
    @Autowired
    private ProductRepository productRepository;
    
    // TODO Lambda Expression
    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            productRepository.save(new Product(1, "iPad Mini", 500.5, 10));
            productRepository.save(new Product(2, "iPad Pro", 1000.8, 5));
            productRepository.save(new Product(3, "MacBook Pro", 2100.0, 2));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Sbtest03Application.class, args);
    }

}

