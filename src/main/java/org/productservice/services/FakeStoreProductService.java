package org.productservice.services;

import org.productservice.dtos.FakeStoreProductDto;
import org.productservice.dtos.GenericProductDto;
import org.productservice.exception.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestURL = "https://fakestoreapi.com/products";
    private String productRequestBaseURL = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestURL,
                product, GenericProductDto.class);
        return response.getBody();
    }

    private GenericProductDto convertFakeStoreDtoIntoGenericProductDto (FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestBaseURL,
                         FakeStoreProductDto[].class );

        List<GenericProductDto> answer = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList()) {

            answer.add(convertFakeStoreDtoIntoGenericProductDto(fakeStoreProductDto));
        }

        return answer;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestURL, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreDtoIntoGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificProductRequestURL
                                , FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id :"+id+ " doesn't exist");
        }

        return convertFakeStoreDtoIntoGenericProductDto(fakeStoreProductDto);
    }
}
