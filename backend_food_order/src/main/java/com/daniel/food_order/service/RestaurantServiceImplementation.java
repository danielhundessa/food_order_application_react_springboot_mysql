package com.daniel.food_order.service;

import com.daniel.food_order.Exception.RestaurantException;
import com.daniel.food_order.dto.RestaurantDto;
import com.daniel.food_order.model.Address;
import com.daniel.food_order.model.Restaurant;
import com.daniel.food_order.model.User;
import com.daniel.food_order.repository.UserRepository;
import com.daniel.food_order.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImplementation implements RestaurantService{

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
        Address address = new Address();
        address.setCity(req.getAddress());

        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws RestaurantException {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws RestaurantException {

    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return null;
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return null;
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws RestaurantException {
        return null;
    }

    @Override
    public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException {
        return null;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws RestaurantException {
        return null;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws RestaurantException {
        return null;
    }
}
