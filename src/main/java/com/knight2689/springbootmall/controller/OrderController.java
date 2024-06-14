package com.knight2689.springbootmall.controller;

import com.knight2689.springbootmall.dto.CreateOrderRequest;
import com.knight2689.springbootmall.dto.OrderQueryPrams;
import com.knight2689.springbootmall.model.Order;
import com.knight2689.springbootmall.service.OrderService;
import com.knight2689.springbootmall.utill.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        OrderQueryPrams orderQueryPrams = new OrderQueryPrams();
        orderQueryPrams.setUserId(userId);
        orderQueryPrams.setLimit(limit);
        orderQueryPrams.setOffset(offset);

        // 取得 order list
        List<Order> orderList = orderService.getOrders(orderQueryPrams);

        // 取得 order 總數
        Integer count = orderService.countOrder(orderQueryPrams);

        // 分頁
        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){

        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
