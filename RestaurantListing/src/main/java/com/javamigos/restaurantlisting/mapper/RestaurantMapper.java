package com.javamigos.restaurantlisting.mapper;

import com.javamigos.restaurantlisting.entity.Restaurant;
import com.javamigos.restaurantlisting.entity.RestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE= Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
