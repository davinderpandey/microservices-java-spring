package com.javamigos.foodcatalogue.service;

import com.javamigos.foodcatalogue.dto.FoodCataloguePage;
import com.javamigos.foodcatalogue.dto.FoodItemDto;
import com.javamigos.foodcatalogue.dto.Restaurant;
import com.javamigos.foodcatalogue.entity.FoodItem;
import com.javamigos.foodcatalogue.mapper.FoodItemMapper;
import com.javamigos.foodcatalogue.repo.FoodItemRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem=FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto);
        FoodItem savedFoodItem= foodItemRepository.save(foodItem);
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItem);
    }

    public FoodCataloguePage fetchFoodCatalogue(Integer restaurantId) {
        List<FoodItem> foodItemList= fetchFoodItemList(restaurantId);
        Restaurant restaurant= fetchRestaurantDetailsFromRMS(restaurantId);
        return createFoodCataloguePage(foodItemList,restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage= new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRMS(Integer restaurantId) {
       return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/"+restaurantId,Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);

    }
}
