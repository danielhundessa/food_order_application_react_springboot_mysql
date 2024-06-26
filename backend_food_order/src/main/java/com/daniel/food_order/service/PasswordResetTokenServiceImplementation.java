package com.daniel.food_order.service;

import com.daniel.food_order.model.PasswordResetToken;
import com.daniel.food_order.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenServiceImplementation implements PasswordResetTokenService{
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;


    @Override
    public PasswordResetToken findByToken(String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        return passwordResetToken;
    }

    @Override
    public void delete(PasswordResetToken resetToken) {
        passwordResetTokenRepository.delete(resetToken);

    }
}
