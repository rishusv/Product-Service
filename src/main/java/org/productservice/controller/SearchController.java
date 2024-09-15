package org.productservice.controller;

import org.productservice.dtos.GenericProductDto;
import org.productservice.dtos.ProductDto;
import org.productservice.dtos.search.FilterDto;
import org.productservice.dtos.search.SearchResponseDto;
import org.productservice.dtos.search.SortingCriteria;
import org.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/")
    public void search(@RequestParam("query") String query,
                       @RequestParam("filters") List<FilterDto> filters,
                       @RequestParam("sortBy") SortingCriteria sortingCriteria,
                       @RequestParam("pageNumber") int pageNumber,
                       @RequestParam("pageSize") int pageSize) {
        {
            SearchResponseDto response = new SearchResponseDto();

            Page<GenericProductDto> productsPage = searchService.search(query, filters, sortingCriteria,
                    pageNumber, pageSize);

            List<GenericProductDto> genericProductDtos = productsPage.getContent().stream()
                    .map(productDto -> {
                        GenericProductDto genericProductDto = new GenericProductDto();
                        genericProductDto.setId(productDto.getId());
                        genericProductDto.setImage(productDto.getImage());
                        genericProductDto.setPrice(productDto.getPrice());
                        return genericProductDto;
                    })
                    .collect(Collectors.toList());

            Page<GenericProductDto> genericProductsPage = new PageImpl<>(genericProductDtos, productsPage.getPageable(), productsPage.getTotalElements());

            response.setProductsPage(genericProductsPage);
        }
    }
    @GetMapping("/byCategory")
    public SearchResponseDto simpleSearch(@RequestParam("query") String query,
                                          @RequestParam("category") Long categoryId,
                                          @RequestParam("pageNumber") int pageNumber,
                                          @RequestParam("pageSize") int pageSize,
                                          @RequestParam("sortingAttribute") String sortingAttribute
    ) {
        return null;
    }
}