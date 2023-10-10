package com.product.service.productservice.controller;

import com.product.service.productservice.payload.ProductDto;
import com.product.service.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping ("/saved")
    public ResponseEntity<ProductDto> created(@RequestBody  ProductDto productDto){
        return new ResponseEntity<ProductDto>(productService.created(productDto), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<ProductDto> getAllData() {
      return  productService.getAllData();
    }

}
