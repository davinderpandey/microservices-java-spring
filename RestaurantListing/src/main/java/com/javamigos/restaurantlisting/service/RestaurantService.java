package com.javamigos.restaurantlisting.service;

import com.javamigos.restaurantlisting.entity.Restaurant;
import com.javamigos.restaurantlisting.entity.RestaurantDto;
import com.javamigos.restaurantlisting.mapper.RestaurantMapper;
import com.javamigos.restaurantlisting.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {



    @Autowired
    RestaurantRepository restaurantRepository;



    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> listOfRestaurants = restaurantRepository.findAll();
        return listOfRestaurants.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).collect(Collectors.toList());
    }

    public RestaurantDto findRestaurantById(Long restaurantId) {
        RestaurantDto restaurantDto =null;
                Optional<Restaurant> restaurant= restaurantRepository.findById(restaurantId);
        if(restaurant.isPresent()){
            restaurantDto =RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get());
        }
        return restaurantDto;
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant=RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantRepository.save(restaurant));
    }
}
