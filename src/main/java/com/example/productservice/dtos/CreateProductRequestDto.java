package com.example.productservice.dtos;

import lombok.Data;

@Data
public class CreateProductRequestDto {
    /*

    title: 'test product',
    price: 13.5,
    description: 'lorem ipsum set',
    image: 'https://i.pravatar.cc',
    category: 'electronic'

    */
    private int productId;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
