package org.productservice.services.filterService;

public class FilterFactory {
    public static Filter getFilterFromKey(String key) {
        return switch (key) {
            case "ram" -> new RAMFilter();
            case "brand" -> new BrandFilter();
            default -> throw new IllegalArgumentException("Invalid filter key");
        };
    }
}
