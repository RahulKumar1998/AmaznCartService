package com.assignment.amazncart.service;

import com.assignment.amazncart.dto.ProductDTO;
import com.assignment.amazncart.entity.Products;

import java.util.List;

public interface ProductServiceInterface {
    Products saveProduct(Products product);

    Products updateProduct(int id, Products product);

    void deleteProduct(int id);

    List<ProductDTO> getProducts(String promotion);
}
