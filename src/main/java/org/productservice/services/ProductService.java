package org.productservice.services;

import org.productservice.dtos.GenericProductDto;
import org.productservice.exception.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;
    GenericProductDto createProduct(GenericProductDto product);
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);
}
