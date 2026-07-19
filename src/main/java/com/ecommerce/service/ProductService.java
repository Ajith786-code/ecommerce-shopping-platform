package com.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.model.Product;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> search(String keyword, Long categoryId, Pageable pageable);
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
