package com.daniel.food_order.model;

import com.daniel.food_order.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;
    private String password;

    private USER_ROLE role;

    private String status;


}
