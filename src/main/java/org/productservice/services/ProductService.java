package org.productservice.services;

import org.productservice.dtos.GenericProductDto;

public interface ProductService {
    GenericProductDto getProductById(Long id);
}
