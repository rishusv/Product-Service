package org.productservice.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.productservice.dtos.GenericProductDto;
import org.productservice.exception.NotFoundException;
import org.productservice.services.ProductService;
import org.productservice.thirdPartyClients.productservice.fakeStore.FakeStoreProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @Autowired
    ProductController productController;

    @MockBean
    @Autowired
    private ProductService productService;

    @Test
    void returnsNullWhenProductDoesntExist() throws NotFoundException {
        GenericProductDto productById = productController.getProductById(121L);

        when(productService.getProductById(any(Long.class)))
                .thenReturn(null);

        assertNull(productById);
    }

    @Test
    void shouldReturnTitleRishuWithProdcutID1() throws NotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle("Rishu");

        when(
                productService.getProductById(1L)
        ).thenReturn(
                genericProductDto
        );

        GenericProductDto genericProductDto1 = productController.getProductById(1L);
        assertEquals("Rishu",genericProductDto1.getTitle());
    }


    @Test
    @DisplayName("1 + 1 euqals 2")
    void testOnePlusOneEqualsTrue() {
        System.out.println("It is true");
//        assert (11==1+11);
        assertEquals(11, 1, "Not Working");
    }

    @Test
    void additionToBeTrue() {
        assert -1 + 1 == 0;
    }
}

//Assertion Framework
// -> allows you to make assertions
// -> aalows you to make checks
