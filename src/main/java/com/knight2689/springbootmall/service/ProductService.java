package com.knight2689.springbootmall.service;


import com.knight2689.springbootmall.constant.ProductCategory;
import com.knight2689.springbootmall.dto.ProductRequest;
import com.knight2689.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProduct(ProductCategory category, String search);

    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer ProductId, ProductRequest productRequest);

    void deleteProductById(Integer ProductId);
}
