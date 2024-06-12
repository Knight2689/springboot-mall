package com.knight2689.springbootmall.service;


import com.knight2689.springbootmall.dto.ProductQueryParams;
import com.knight2689.springbootmall.dto.ProductRequest;
import com.knight2689.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProduct(ProductQueryParams productQueryParams);

    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer ProductId, ProductRequest productRequest);

    void deleteProductById(Integer ProductId);
}
