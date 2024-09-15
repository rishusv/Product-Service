package org.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.productservice.models.Category;
import org.productservice.models.Product;

@Getter
@Setter
public class GenericProductDto { //this is one we return
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public static GenericProductDto from(Product product) {
        GenericProductDto getProductResponseDto = new GenericProductDto();
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setImage(product.getImage());
        getProductResponseDto.setTitle(product.getTitle());
        return getProductResponseDto;
    }
}
