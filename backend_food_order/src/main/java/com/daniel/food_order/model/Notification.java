package com.daniel.food_order.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;
    private boolean readStatus;
}
