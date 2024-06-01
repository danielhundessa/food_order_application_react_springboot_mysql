package com.daniel.food_order.repository;

import com.daniel.food_order.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
PasswordResetToken findByToken(String token);
}
