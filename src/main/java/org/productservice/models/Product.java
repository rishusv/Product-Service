package org.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    // P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans :   m : 1
    @ManyToOne
    @JoinColumn
    private Category category;
    private double price;
}
