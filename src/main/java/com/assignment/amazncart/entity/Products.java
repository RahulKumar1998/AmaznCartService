package com.assignment.amazncart.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    private String currency;
    private String origin;
    private Double rating;
    private String category;
    private Integer inventory;

    @JsonProperty("arrival_status")
    private String arrivalStatus;
}
