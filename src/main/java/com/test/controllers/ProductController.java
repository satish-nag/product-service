package com.test.controllers;

import com.test.model.Product;
import com.test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "allprods")
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    @GetMapping(path="oneprod/{id}")
    public Product getOneProduct(@PathVariable Integer id){
        return productRepository.findOne(id);
    }

    @PostMapping(path = "addProd",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<?> addProduct(@Valid @RequestBody List<Product> products, BindingResult result){
        if(!result.hasErrors()){
            return result.getAllErrors();
        }
        Iterable<Product> products1 = productRepository.save(products);
        return Arrays.asList(products1);
    }

    @DeleteMapping(path = "deleteProd/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
           productRepository.delete(id);
           return ResponseEntity.noContent().build();
    }

    @PutMapping(path="modifyProd")
    public List<?> modifyProduct(@Valid @RequestBody List<Product> products, BindingResult result){
        if(!result.hasErrors()){
            return result.getAllErrors();
        }
        Iterable<Product> products1 = productRepository.save(products);
        return Arrays.asList(products1);
    }
}
