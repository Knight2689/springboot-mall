package com.knight2689.springbootmall.service.impl;

import com.knight2689.springbootmall.constant.ProductCategory;
import com.knight2689.springbootmall.dao.ProductDao;
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
    public List<Product> getProduct(ProductCategory category, String search) {
        return productDao.getProducts(category, search);
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
