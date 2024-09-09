package org.productservice.repository;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.productservice.models.Category;
import org.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByTitleEqualsAndPrice_Price(String title, double price);

    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, //checked at runtime
            nativeQuery = true)
    Product findByTitle(String title);

    @Query("select Product from Product where Product.title= :rishu")
        //hibernate Query , checked at compile time
    List<Product> readAllByTitle(String rishu); //hibernate query -> independent of DB

    List<Product> findAllByCategoryIn(List<Category> categories);
}
