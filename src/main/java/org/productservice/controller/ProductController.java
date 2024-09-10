package org.productservice.controller;

import org.productservice.dtos.ExceptionDto;
import org.productservice.dtos.GenericProductDto;
import org.productservice.exception.NotFoundException;
import org.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping()
//    public List<GenericProductDto> getAllProducts() {
//        System.out.println("Hello");
//        return productService.getAllProducts();
//    }

    @GetMapping
    public ResponseEntity<List<GenericProductDto>> getAllProducts() {
        List<GenericProductDto> productDtos = productService.getAllProducts();
        if (productDtos.isEmpty()) {
            return new ResponseEntity<>(
                    productDtos,
                    HttpStatus.NOT_FOUND
            );
        }

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (GenericProductDto gpd: productDtos) {
            genericProductDtos.add(gpd);
        };

//        genericProductDtos.remove(genericProductDtos.get(0));

        return new ResponseEntity<>(genericProductDtos, HttpStatus.OK);

//        productDtos.get(0).setId(1001L);
//
//        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

 @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
     return new ResponseEntity<>(
                 productService.deleteProductById(id),
                         HttpStatus.NOT_FOUND
                 );
    }
    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
//        return "New Product "+ UUID.randomUUID();
    }
//
//    @PutMapping("{id}")
//    public void updateProductById() {
//    }

}
