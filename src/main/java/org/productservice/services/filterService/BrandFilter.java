package org.productservice.services.filterService;

import org.productservice.models.Product;

import java.util.List;

public class BrandFilter implements Filter {
    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        return null;
    }
}

