package org.productservice.services.filterService;

import org.productservice.dtos.search.FilterDto;
import org.productservice.models.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products,
                        List<String> allowedValues);
}
