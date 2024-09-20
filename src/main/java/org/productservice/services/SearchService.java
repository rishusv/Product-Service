//package org.productservice.services;
//
//import org.productservice.dtos.GenericProductDto;
//import org.productservice.dtos.ProductDto;
//import org.productservice.dtos.search.FilterDto;
//import org.productservice.dtos.search.SortingCriteria;
//import org.productservice.models.Product;
//import org.productservice.repository.ProductRepository;
//import org.productservice.services.filterService.FilterFactory;
//import org.productservice.services.sortingService.SorterFactory;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class SearchService {
//
//    private ProductRepository productRepository;
//
//    public SearchService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    public Page<GenericProductDto> search(
//            String query,
//            List<FilterDto> filters,
//            SortingCriteria sortingCriteria,
//            int pageNumber,
//            int pageSize
//    ){
//        List<Product> products = productRepository.findByTitleContaining(query);
//
//        for(FilterDto filterDto: filters){
//            products = FilterFactory.getFilterFromKey(
//                    filterDto.getKey()
//            ).apply(products, filterDto.getValues());
//        }
//        products = SorterFactory.getSorterByCriteria(sortingCriteria).sort(products);
//
//        List<GenericProductDto> productsOnPage = new ArrayList<>();
//
//        for (int i = pageSize * (pageNumber - 1); i <= (pageSize * pageNumber) - 1; ++i) {
//            productsOnPage.add(GenericProductDto.from(products.get(i)));
//        }
//
//        Pageable pageable = PageRequest.of(pageNumber, pageSize); // Adjust page number and size as needed
//        return new PageImpl<>(productsOnPage, pageable, products.size());
//        }
//
//    public Page<Product> simpleSearch(
//            String query,
//            Long categoryId,
//            int pageNumber,
//            int pageSize,
//            String sortingAttribute
//    ) {
//        // select * from products
//        // where title like "%query%"
//        // and categoryID = {categoryId}
//        // limit {pageSize} offset pageNumbver * pageSize
//        // orderBy sortingAttribute;
//
//        Page<Product> products = productRepository
//                .findAllByTitleContainingAndCategory_Id(
//                        query, categoryId,
//                        PageRequest.of(
//                                pageNumber,
//                                pageSize,
//                                Sort.by(sortingAttribute).descending()));
//
//        return products;
//    }
//}
