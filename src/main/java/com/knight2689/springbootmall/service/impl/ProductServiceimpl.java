package com.knight2689.springbootmall.service.impl;

import com.knight2689.springbootmall.dao.ProductDao;
import com.knight2689.springbootmall.model.Product;
import com.knight2689.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer ProductId) {
        return productDao.getProductById(ProductId);
    }
}
