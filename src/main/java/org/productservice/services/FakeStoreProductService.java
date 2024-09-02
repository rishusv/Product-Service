package org.productservice.services;

import org.productservice.dtos.FakeStoreProductDto;
import org.productservice.dtos.GenericProductDto;
import org.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestURL = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestURL,
                product, GenericProductDto.class);
        return response.getBody();
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(getProductRequestURL
                                , FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();


        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());

        return product;
    }
}
