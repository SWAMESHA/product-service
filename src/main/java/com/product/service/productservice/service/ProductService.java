package com.product.service.productservice.service;

import com.product.service.productservice.payload.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto created(ProductDto productDto);

    List<ProductDto> getAllData();
}
