package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    @JsonIgnore
    private Category category;
    private double rating;
}

/*
* Product : Category
*   1       :    1
*   M       :    1
*
* */
