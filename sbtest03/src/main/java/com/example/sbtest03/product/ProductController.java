package com.example.sbtest03.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class ProductController {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/product")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        /*
        // 1. Non error handling
        return productRepository.findById(id).get();
        */
        
        /*
        // 2. Use isPresent()
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            return new Product();
        }
        return product.get();
        */
        
        /*
        // 3. Use Supplier
        return productRepository.findById(id).orElseGet(new Supplier<Product>() {
            @Override
            public Product get() {
                return new Product();
            }
        });
        */

        // 4. Use Method Reference
        return productRepository.findById(id).orElseGet(Product::new);
    }
}
