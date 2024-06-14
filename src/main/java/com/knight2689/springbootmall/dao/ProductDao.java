package com.knight2689.springbootmall.dao;

import com.knight2689.springbootmall.dto.ProductQueryParams;
import com.knight2689.springbootmall.dto.ProductRequest;
import com.knight2689.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams  productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void updateStock(Integer proudctId, Integer stock);

    void deleteProductById(Integer productId);
}
