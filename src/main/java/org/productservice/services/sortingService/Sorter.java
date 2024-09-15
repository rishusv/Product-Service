package org.productservice.services.sortingService;

import org.productservice.models.Product;

import java.util.List;

public interface Sorter {
    List<Product> sort(List<Product> products);
}
