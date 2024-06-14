package com.knight2689.springbootmall.service.impl;

import com.knight2689.springbootmall.dao.OrderDao;
import com.knight2689.springbootmall.dao.ProductDao;
import com.knight2689.springbootmall.dao.UserDao;
import com.knight2689.springbootmall.dto.BuyItem;
import com.knight2689.springbootmall.dto.CreateOrderRequest;
import com.knight2689.springbootmall.dto.OrderQueryPrams;
import com.knight2689.springbootmall.model.Order;
import com.knight2689.springbootmall.model.OrderItem;
import com.knight2689.springbootmall.model.Product;
import com.knight2689.springbootmall.model.User;
import com.knight2689.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countOrder(OrderQueryPrams orderQueryPrams) {
        return orderDao.countOrder(orderQueryPrams);
    }

    @Override
    public List<Order> getOrders(OrderQueryPrams orderQueryPrams) {
        List<Order> orderList = orderDao.getOrders(orderQueryPrams);

        for (Order order : orderList){
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());

            order.setOrderItemList(orderItemList);
        }

        return orderList;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        // 檢查 user 是否存在
        User user = userDao.getUserById(userId);

        if (user == null){
            log.warn("該 userId {} 不存在", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }


        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();


        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 檢查 product 是否存在、庫存是否足夠
            if (product == null){
                log.warn("商品 {} 不存在", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.getStock() < buyItem.getQuantity()){
                log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {} , 欲購買數量 {}",
                        buyItem.getProductId(),product.getStock(),buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            // 扣除商品庫存
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());


            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }
        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);



        return orderId;
    }
}
