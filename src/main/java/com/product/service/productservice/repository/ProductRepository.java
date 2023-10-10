package com.product.service.productservice.repository;

import com.product.service.productservice.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
