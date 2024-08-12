package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category category;
    private double rating;
}
/*
*       1   :   1
*   Product : Category
*       M    :   1
* */
