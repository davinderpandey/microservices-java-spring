package com.javamigos.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private List<FoodItemDto> foodItemDtoList;
    private Restaurant restaurant;
    private UserDto userDto;

}
