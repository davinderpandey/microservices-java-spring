package com.javamigos.foodcatalogue.controller;

import com.javamigos.foodcatalogue.dto.FoodCataloguePage;
import com.javamigos.foodcatalogue.dto.FoodItemDto;
import com.javamigos.foodcatalogue.entity.FoodItem;
import com.javamigos.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto savedFoodItem=foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("fetchFoodCatalogueByRestaurantId/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchFoodCataloguePage(@PathVariable Integer restaurantId ){
        return new ResponseEntity<>(foodCatalogueService.fetchFoodCatalogue(restaurantId),HttpStatus.OK);
    }


}
