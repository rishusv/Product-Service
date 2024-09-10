package org.productservice;

import org.productservice.models.Category;
import org.productservice.models.Price;
import org.productservice.models.Product;
import org.productservice.repository.CategoryRepository;
import org.productservice.repository.PriceRepository;
import org.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
//        implements CommandLineRunner {
//    ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public ProductServiceApplication(ProductRepository productRepository,
//                                     CategoryRepository categoryRepository,
//                                     PriceRepository priceRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Category category=new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        Price savedPrice = priceRepository.save(price);
//
//        Product product =new Product();
//        product.setDescription("iPhone");
////        product.setPrice(200000);
//        product.setTitle("16");
//        product.setCategory(savedCategory);
//        product.setPrice(savedPrice);
//
//        productRepository.save(product);
//    }
}
