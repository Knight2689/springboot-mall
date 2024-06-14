package com.knight2689.springbootmall.service;

import com.knight2689.springbootmall.dto.CreateOrderRequest;
import com.knight2689.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
