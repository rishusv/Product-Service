package org.productservice.services;

import org.productservice.dtos.GenericProductDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class SelfService implements ProductService{

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }
}
