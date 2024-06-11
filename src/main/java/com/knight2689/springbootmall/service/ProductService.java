package com.knight2689.springbootmall.service;


import com.knight2689.springbootmall.dto.ProductRequest;
import com.knight2689.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);
}
