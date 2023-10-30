package com.javamigos.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromFE {

    List<FoodItemDto> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;
}
