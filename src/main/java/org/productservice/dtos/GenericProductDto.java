package org.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.productservice.models.Category;
@Getter
@Setter
public class GenericProductDto { //this is one we return
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
