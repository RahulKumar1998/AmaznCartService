package com.assignment.amazncart.service;

import com.assignment.amazncart.entity.Products;
import com.assignment.amazncart.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements ProductServiceInterface{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products updateProduct(int id, Products product) {
        Products existingProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product does not exist!!"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setCurrency(product.getCurrency());
        existingProduct.setArrivalStatus(product.getArrivalStatus());
        existingProduct.setInventory(product.getInventory());
        existingProduct.setRating(product.getRating());
        existingProduct.setOrigin(product.getOrigin());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }
}
