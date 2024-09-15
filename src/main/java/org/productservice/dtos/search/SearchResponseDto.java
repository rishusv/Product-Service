package org.productservice.dtos.search;

import lombok.Getter;
import lombok.Setter;
import org.productservice.dtos.GenericProductDto;
import org.productservice.dtos.ProductDto;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SearchResponseDto {
    private Page<GenericProductDto> productsPage;
}
