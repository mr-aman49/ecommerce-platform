package com.product_service.product_service.service;


import com.product_service.product_service.model.Product;
import com.product_service.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
