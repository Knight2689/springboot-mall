package com.knight2689.springbootmall.dao;

import com.knight2689.springbootmall.dto.ProductRequest;
import com.knight2689.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest proudctRequest);

    void updateProduct(Integer ProductId, ProductRequest productRequest);

    void deleteProductById(Integer ProductId);
}
