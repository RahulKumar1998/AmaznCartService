package com.assignment.amazncart.service;

import com.assignment.amazncart.dto.ProductDTO;
import com.assignment.amazncart.entity.Products;
import com.assignment.amazncart.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceInterface{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    @Autowired
    private DiscountCalculator discountCalculator;


    @Override
    public List<ProductDTO> getProducts(String promotionSet) {
        List<Products> products = productRepository.findAll();
        return products.stream().map(product ->{
            Double priceInINR = currencyConverter.convertToInr(product.getPrice(), product.getCurrency());
            DiscountResult discountResult = discountCalculator.calculateDiscount(product, priceInINR, promotionSet);

            // Create ProductDTO and populate the fields
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setCategory(product.getCategory());
            productDTO.setRating(product.getRating());
            productDTO.setInventory(product.getInventory());
            productDTO.setOrigin(product.getOrigin());
            productDTO.setOriginalPrice(product.getPrice());
            productDTO.setOriginalCurrency(product.getCurrency());
            productDTO.setPriceInINR(priceInINR);
            productDTO.setDiscountTag(discountResult.getDiscountTag());
            productDTO.setDiscountAppliedInINR(discountResult.getDiscountAmount());
            productDTO.setFinalPriceInINR(priceInINR - discountResult.getDiscountAmount());
            return productDTO;
        }).collect(Collectors.toList());
    }

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
