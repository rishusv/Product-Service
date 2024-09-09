package org.productservice.repository;

public interface CustomQueries {
    String FIND_ALL_BY_TITLE = "select * from product where title = :title";
}
