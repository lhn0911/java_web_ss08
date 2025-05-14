package com.rikkei.ss08.repository;

import com.rikkei.ss08.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> findAll() {
        return Arrays.asList(
                new Product(1, "Laptop Dell",100, 100.0),
                new Product(2, "Laptop HP",100, 150.0),
                new Product(3, "Laptop Asus",100, 200.0)
        );
    }
}
