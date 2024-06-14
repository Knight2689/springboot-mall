package com.knight2689.springbootmall.service;

import com.knight2689.springbootmall.dto.CreateOrderRequest;
import com.knight2689.springbootmall.dto.OrderQueryPrams;
import com.knight2689.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryPrams orderQueryPrams);

    List<Order> getOrders(OrderQueryPrams orderQueryPrams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
