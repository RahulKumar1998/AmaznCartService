package com.assignment.amazncart.service;

import com.assignment.amazncart.entity.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DiscountCalculator implements DiscountCalculatorInterface {

    @Override
    public DiscountResult calculateDiscount(Products product, Double priceInInr, String promotionSet) {
        List<DiscountResult> discounts = new ArrayList<>();

        if ("SetA".equals(promotionSet)) {
            if ("UAE".equalsIgnoreCase(product.getOrigin())) {
                discounts.add(new DiscountResult(priceInInr * 0.06, "get 5% off !"));  // 6% discount for UAE origin
            }
            if (product.getRating() != null && product.getRating() == 2) {
                discounts.add(new DiscountResult(priceInInr * 0.04, "get 4% off !"));  // 4% discount for rating of 2
            } else if (product.getRating() != null && product.getRating() < 2) {
                discounts.add(new DiscountResult(priceInInr * 0.08, "get 8% off !"));  // 8% discount for rating below 2
            }
            if (Arrays.asList("electronics", "furnishing").contains(product.getCategory()) && priceInInr >= 500) {
                discounts.add(new DiscountResult(100.0, "get Flat Rs. 100 discount on Electronics/Furnishing !"));  // Flat Rs. 100 discount for electronics/furnishing items priced at above Rs. 500
            }
        } else if ("SetB".equals(promotionSet)) {
            if (product.getInventory() > 20) {
                discounts.add(new DiscountResult(priceInInr * 0.12, "get 12% off !"));  // 12% discount for inventory > 20
            }
            if ("new".equalsIgnoreCase(product.getArrivalStatus())) {
                discounts.add(new DiscountResult(priceInInr * 0.07, "New Arrivals, get 7% off !"));  // 7% discount for new arrival status
            }
        }

        if (priceInInr > 1000 && discounts.isEmpty()) {
            discounts.add(new DiscountResult(priceInInr * 0.02, "get 2% off !"));  // Default 2% discount if no other discounts are applied
        }

        return discounts.stream().max((d1, d2)-> d1.getDiscountAmount().compareTo(d2.getDiscountAmount()))
                .orElse(new DiscountResult(0.0, "No Discount Applicable on this item !"));
    }
}
