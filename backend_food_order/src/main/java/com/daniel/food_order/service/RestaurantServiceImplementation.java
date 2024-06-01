package com.daniel.food_order.service;

import com.daniel.food_order.Exception.RestaurantException;
import com.daniel.food_order.dto.RestaurantDto;
import com.daniel.food_order.model.Address;
import com.daniel.food_order.model.Restaurant;
import com.daniel.food_order.model.User;
import com.daniel.food_order.repository.AddressRepository;
import com.daniel.food_order.repository.RestaurantRepository;
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

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
        Address address = new Address();
        address.setCity(req.getAddress().getCity());
        address.setCountry(req.getAddress().getCountry());
        address.setFullName(req.getAddress().getFullName());
        address.setPostalCode(req.getAddress().getPostalCode());
        address.setState(req.getAddress().getState());
        address.setStreetAddress(req.getAddress().getStreetAddress());

        Address savedAddress = addressRepository.save(address);

        Restaurant restaurant = new Restaurant();

        restaurant.setAddress(savedAddress);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(req.getRegistrationDate());
        restaurant.setOwner(user);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return savedRestaurant;
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
