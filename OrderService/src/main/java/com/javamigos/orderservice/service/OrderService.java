package com.javamigos.orderservice.service;

import com.javamigos.orderservice.dto.OrderDto;
import com.javamigos.orderservice.dto.OrderDtoFromFE;
import com.javamigos.orderservice.dto.UserDto;
import com.javamigos.orderservice.entity.Order;
import com.javamigos.orderservice.mapper.OrderMapper;
import com.javamigos.orderservice.repository.OrderRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;


    public OrderDto saveOrderInDB(OrderDtoFromFE orderDetails) {
        int newOrderId= sequenceGenerator.generateSequence(Order.SEQUENCE_NAME);
        UserDto userDto = fetchUserFromUserMS(orderDetails.getUserId());
        Order orderToBeSaved= new Order( newOrderId,orderDetails.getFoodItemDtoList(),orderDetails.getRestaurant(),userDto);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDto fetchUserFromUserMS(Integer userId) {
       return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+ userId,UserDto.class);
    }
}
