package com.javamigos.orderservice.controller;

import com.javamigos.orderservice.dto.OrderDto;
import com.javamigos.orderservice.dto.OrderDtoFromFE;
import com.javamigos.orderservice.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDetails) {
        OrderDto savedOrder = orderService.saveOrderInDB(orderDetails);
        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }


}
