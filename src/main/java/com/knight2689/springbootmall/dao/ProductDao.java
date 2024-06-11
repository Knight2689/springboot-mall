package com.knight2689.springbootmall.dao;

import com.knight2689.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}
