package com.test;

import com.test.model.Product;
import com.test.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return (args) -> {
            Product product1 = new Product("Book","Fountain Head",new BigDecimal(8.99));
            Product product2 = new Product("Phone","IPhone 7 32GB",new BigDecimal(620));
            Product product3 = new Product("Camera","Nikon D3400 DSLR",new BigDecimal(649));

            productRepository.save(Arrays.asList(product1,product2,product3));

        };
    }
}
