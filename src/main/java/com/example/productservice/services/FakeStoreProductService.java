package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductResponseDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.models.Rating;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service("fakeStore")
public class FakeStoreProductService implements ProductService {

    private WebClient webClient;
    private RestTemplate restTemplate;
    String baseUrl = "https://fakestoreapi.com/products";


    public FakeStoreProductService(WebClient.Builder webClient, RestTemplate restTemplate) {
        this.webClient = webClient.baseUrl(baseUrl).build();
        this.restTemplate = restTemplate;
    }

//    Convert response DTO to Product
    private Product convertToProduct(FakeStoreProductResponseDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());

        Category category=new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);

        Rating rating=new Rating();
        rating.setRate(dto.getRating().getRate());
        rating.setCount(dto.getRating().getCount());
        product.setRating(rating.getRate());

        return product;


    }


    @Override
    public Product createProduct(String title, double price, String description, String image, String category,double rating) {
        return null;
    }

    // GET all products from Fake store API
    @Override
    public List<Product> getAllProducts() {
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(FakeStoreProductResponseDto.class)
                .toStream()
                .map(this::convertToProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void updateProductPrice(Long id, Double price) {

    }

    @Override
    public void updateProductDescription(Long id, String description) {

    }

    @Override
    public void updateProductImage(Long id, String image) {

    }





    @Override
    public List<Product> getAllProductsByCategory(Long categoryId) {
        return List.of();
    }


//    // POST product on Fake store
//    @Override
//    public Product createProduct(String title, double price, String description, String image, long categoryId) {
////        CreateProductRequestDto requestDto=new CreateProductRequestDto();
////        requestDto.setTitle(title);
////        requestDto.setPrice(price);
////        requestDto.setDescription(description);
////        requestDto.setImage(image);
////        requestDto.setCategory(category);
////
////        CreateProductRequestDto responseDto= restTemplate.postForObject(baseUrl,requestDto,CreateProductRequestDto.class);
////
////        if(responseDto!=null){
////            Product product=new Product();
////            product.setName((responseDto.getTitle()));
////            product.setDescription((responseDto.getDescription()));
////            product.setPrice(responseDto.getPrice());
////            product.setImageUrl((responseDto.getImage()));
////            Category productCategory=new Category();
////            productCategory.setName(responseDto.getCategory());
////            product.setCategory(productCategory);
////            return product;
//        return null;
//
//        }
//    }


    // DELETE product on Fake store
//    @Override
//    public void deleteProductById(long id) {
//        System.out.println("Delete product by id: " + id);
////            restTemplate.delete(baseUrl+"/"+id);
//    }


    //    PATCH product of Fake Store
//    @Override
//    public void updateProduct(Long id,
//                                 String title,
//                                 Double price,
//                                 String description,
//                                 String image,
//                                 String category,
//                                 Rating rating) {
//        FakeStoreProductResponseDto dto=new FakeStoreProductResponseDto();
//        dto.setId(id);
//        dto.setTitle(title);
//        dto.setPrice(price);
//        dto.setDescription(description);
//        dto.setImage(image);
//        dto.setCategory(category);
//        dto.setRating(rating);
//        convertToProduct(dto);
//        restTemplate.patchForObject(baseUrl+"/"+id,dto,Void.class);
//    }


    // GET product by id
//    @Override
//    public Product getProductById(Long id) {
//       FakeStoreProductResponseDto responseDto=webClient.get()
//               .uri(baseUrl+"/"+id)
//               .retrieve()
//               .bodyToMono(FakeStoreProductResponseDto.class)
//               .block();
//       if(responseDto!=null){
//           return convertToProduct(responseDto);
//       }
//        return null;
//    }


    //    GET all categories

//    @Override
//    public List<Category> getAllCategories() {
//        String[] responseDto=restTemplate.getForObject(baseUrl+"/categories", String[].class);
//        assert responseDto != null;
//        List<Category> categories= Arrays.stream(responseDto)
//                .map(name->{
//                    Category category=new Category();
//                    category.setName(name);
//                    return category;
//                })
//                .toList();
//        return categories;
//        return null;
//
//    }

//    @Override
//    public List<Product> getAllProductsByCategory(String category) {
//
//        FakeStoreProductResponseDto[] responseDto=restTemplate.getForObject(
//                baseUrl+"/category/"+category,
//                FakeStoreProductResponseDto[].class
//        );
//        return Arrays.stream(responseDto)
//                .map(this::convertToProduct)
//                .toList();
//    }



}
