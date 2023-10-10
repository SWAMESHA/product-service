package com.product.service.productservice.serviceImple;

import com.product.service.productservice.module.Product;
import com.product.service.productservice.payload.ProductDto;
import com.product.service.productservice.repository.ProductRepository;
import com.product.service.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor//or Autowired or @RequiredArgsConstructor this one use apply for final
public class ProductServiceImpl implements ProductService {
    

//    private final ProductRepository productRepository;

    private ProductRepository productRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    
    public Product mapToEntity(ProductDto productDto ){
        Product product = mapper.map(productDto, Product.class);
        return product;
    }
    
    public ProductDto mapToDto(Product product){
        ProductDto productDto = mapper.map(product, ProductDto.class);
        return productDto;
    }
    
    
    @Override
    public ProductDto created(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product productEntity = productRepository.save(product);
        ProductDto productDto1 = mapToDto(productEntity);

        return productDto1;
    }

    @Override
    public List<ProductDto> getAllData() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(productss -> mapToDto(productss)).collect(Collectors.toList());

        return productDtos;
    }
}
