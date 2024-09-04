package org.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category")//this is the same relation being mapped by other class
    private List<Product> products;

}
