package com.assignment.amazncart.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Double originalPrice;
    private String originalCurrency;
    private String category;
    private Double rating;
    private String origin;
    private Integer inventory;
    private Double priceInINR;
    private Double discountAppliedInINR;
    private String discountTag;
    private Double finalPriceInINR;

}
