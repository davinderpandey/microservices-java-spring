package com.javamigos.restaurantlisting.controller;

import com.javamigos.restaurantlisting.entity.Restaurant;
import com.javamigos.restaurantlisting.entity.RestaurantDto;
import com.javamigos.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/findAllRestaurants")
    ResponseEntity<List<RestaurantDto>> getAllRestaurantList(){
       return new ResponseEntity<>(restaurantService.findAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("/{restaurantId}")
    ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable("restaurantId") Long restaurantId){
        return new ResponseEntity<>(restaurantService.findRestaurantById(restaurantId),HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        RestaurantDto restaurantDto1 = restaurantService.addRestaurant(restaurantDto);
        return new ResponseEntity<>(restaurantDto1,HttpStatus.CREATED);
    }


}
