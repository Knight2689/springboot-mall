package com.knight2689.springbootmall.dao;

import com.knight2689.springbootmall.dto.OrderQueryPrams;
import com.knight2689.springbootmall.model.Order;
import com.knight2689.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryPrams orderQueryPrams);

    List<Order> getOrders(OrderQueryPrams orderQueryPrams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
