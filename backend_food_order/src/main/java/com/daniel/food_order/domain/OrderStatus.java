package com.daniel.food_order.domain;

public enum OrderStatus {
    RECEIVED,
    PENDING,
    READY_FOR_PICKUP,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED
}
