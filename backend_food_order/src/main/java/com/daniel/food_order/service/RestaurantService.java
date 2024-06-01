package com.daniel.food_order.service;

import com.daniel.food_order.Exception.RestaurantException;
import com.daniel.food_order.dto.RestaurantDto;
import com.daniel.food_order.model.Restaurant;
import com.daniel.food_order.model.User;
import com.daniel.food_order.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant)
        throws RestaurantException;

    public void deleteRestaurant(Long restaurantId) throws RestaurantException;
    public List<Restaurant>getAllRestaurant();
    public List<Restaurant>searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws RestaurantException;
    public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException;
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws RestaurantException;

    public Restaurant updateRestaurantStatus(Long id) throws RestaurantException;
}
