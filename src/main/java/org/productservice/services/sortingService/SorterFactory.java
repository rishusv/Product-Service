package org.productservice.services.sortingService;

import org.productservice.dtos.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(SortingCriteria sortingCriteria) {
        return switch (sortingCriteria){
            case RELEVANCE -> null;
            case POPULARUTY -> null;
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowerSorter();
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            case RATING_HIGH_TO_LOW -> null;
            case RATING_LOW_TO_HIGH -> null;
            default -> null;
        };
    }
}
