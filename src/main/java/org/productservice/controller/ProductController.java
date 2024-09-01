package org.productservice.controller;

import org.productservice.dtos.GenericProductDto;
import org.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public void getAllProducts() {
        System.out.println("Hello");
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

//    @DeleteMapping("{id}")
//    public void deleteProductById() {
//    }
//
    @PostMapping()
    public String createProduct() {
        return "New Product "+ UUID.randomUUID();
    }
//
//    @PutMapping("{id}")
//    public void updateProductById() {
//    }
}
