package org.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto { //for External Object
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
