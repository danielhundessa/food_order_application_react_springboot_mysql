package com.daniel.food_order.response;

import com.daniel.food_order.domain.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String message;
    private String jwt;
    private USER_ROLE role;
}
