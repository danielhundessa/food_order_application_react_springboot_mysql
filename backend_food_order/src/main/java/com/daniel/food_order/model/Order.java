package com.daniel.food_order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalAmount;
    private String orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private int totalItem;
    private int totalPrice;

}
