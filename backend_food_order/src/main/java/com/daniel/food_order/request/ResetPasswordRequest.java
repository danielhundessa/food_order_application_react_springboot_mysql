package com.daniel.food_order.request;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String password;
    private String token;
}
