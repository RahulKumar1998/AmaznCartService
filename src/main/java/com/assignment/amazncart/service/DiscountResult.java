package com.assignment.amazncart.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiscountResult {

    private Double discountAmount;
    private String discountTag;
}
