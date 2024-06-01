package com.daniel.food_order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NonNull String token;
    private @NonNull Date expiryDate;

    public PasswordResetToken(String resetToken, User user, Date expiryDate) {
    }

    private boolean isExpired(){
        return expiryDate.before(new Date());
    }
}
