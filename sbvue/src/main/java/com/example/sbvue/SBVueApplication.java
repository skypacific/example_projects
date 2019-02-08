package com.example.sbvue;

import com.example.sbvue.product.Product;
import com.example.sbvue.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SBVueApplication {
    
    private final ProductRepository productRepository;

    @Autowired
    public SBVueApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // TODO Lambda Expression
    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            productRepository.save(new Product(1, "iPad Mini", 500.5, 10));
            productRepository.save(new Product(2, "iPad Pro", 1000.8, 5));
            productRepository.save(new Product(3, "MacBook Pro", 2100.3, 2));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SBVueApplication.class, args);
    }

}

