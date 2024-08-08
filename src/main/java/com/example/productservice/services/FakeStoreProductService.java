package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreResponseDto;
import com.example.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    String url = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) {

        ResponseEntity<FakeStoreResponseDto> response =restTemplate.getForEntity(url + "/" + id, FakeStoreResponseDto.class);
        FakeStoreResponseDto fakeStoreResponseDto = response.getBody();
        return fakeStoreResponseDto.toProduct();
    }

    @Override
    public Product createProduct(String title, Double price, String description, String image, String category) {
        FakeStoreResponseDto fakeStoreResponseDto = new FakeStoreResponseDto();
        fakeStoreResponseDto.setTitle(title);
        fakeStoreResponseDto.setPrice(price);
        fakeStoreResponseDto.setDescription(description);
        fakeStoreResponseDto.setImage(image);
        fakeStoreResponseDto.setCategory(category);

        FakeStoreResponseDto responseDto= restTemplate.postForObject(url, fakeStoreResponseDto, FakeStoreResponseDto.class);
        return responseDto.toProduct();
    }
}
