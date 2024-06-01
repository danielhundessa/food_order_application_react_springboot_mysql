package com.daniel.food_order.service;

import com.daniel.food_order.model.PasswordResetToken;

public interface PasswordResetTokenService {
    public PasswordResetToken findByToken(String token);
    public void delete(PasswordResetToken resetToken);
}
