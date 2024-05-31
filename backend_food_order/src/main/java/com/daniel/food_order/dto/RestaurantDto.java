package com.daniel.food_order.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class RestaurantDto {
    private String title;
    private String description;
    private Long id;
}
