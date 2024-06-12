package com.knight2689.springbootmall.service.impl;

import com.knight2689.springbootmall.dao.ProductDao;
import com.knight2689.springbootmall.dto.ProductQueryParams;
import com.knight2689.springbootmall.dto.ProductRequest;
import com.knight2689.springbootmall.model.Product;
import com.knight2689.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productDao.countProduct(productQueryParams);
    }

    @Override
    public List<Product> getProduct(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

    @Override
    public Product getProductById(Integer ProductId) {
        return productDao.getProductById(ProductId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer ProductId, ProductRequest productRequest) {
        productDao.updateProduct(ProductId, productRequest);
    }

    @Override
    public void deleteProductById(Integer ProductId) {
        productDao.deleteProductById(ProductId);
    }
}
