package com.assignment.amazncart.service;

import com.assignment.amazncart.entity.Products;

public interface DiscountCalculatorInterface {
    DiscountResult calculateDiscount(Products product, Double priceInInr, String promotionSet);
}
