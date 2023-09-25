package com.javamigos.orderservice.entity;

import com.javamigos.orderservice.dto.FoodItemDto;
import com.javamigos.orderservice.dto.Restaurant;
import com.javamigos.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int orderId;
    private List<FoodItemDto> foodItemDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
