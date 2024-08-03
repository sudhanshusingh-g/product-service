package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreDto;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, Double price,String description,String image,String category) {
        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setTitle(title);
        fakeStoreDto.setPrice(price);
        fakeStoreDto.setDescription(description);
        fakeStoreDto.setImage(image);
        fakeStoreDto.setCategory(category);
        FakeStoreDto response =restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreDto,FakeStoreDto.class);
        return response.toProduct();
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreDto fakeStoreDto=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreDto.class);
        return fakeStoreDto.toProduct();
    }
}
