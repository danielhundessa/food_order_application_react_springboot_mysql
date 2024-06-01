package com.daniel.food_order.Exception;

public class RestaurantException extends Exception{
    private static final Long serialVersionUID = 1L;
    public RestaurantException(String message) {
        super(message);
    }
}
