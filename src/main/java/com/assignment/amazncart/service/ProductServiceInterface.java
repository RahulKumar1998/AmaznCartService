package com.assignment.amazncart.service;

import com.assignment.amazncart.entity.Products;

public interface ProductServiceInterface {
    Products saveProduct(Products product);

    Products updateProduct(int id, Products product);

    void deleteProduct(int id);
}
