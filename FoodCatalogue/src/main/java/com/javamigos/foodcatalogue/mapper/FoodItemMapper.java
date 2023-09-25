package com.javamigos.foodcatalogue.mapper;

import com.javamigos.foodcatalogue.entity.FoodItem;
import com.javamigos.foodcatalogue.dto.FoodItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto restaurantDto);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem restaurant);
}
