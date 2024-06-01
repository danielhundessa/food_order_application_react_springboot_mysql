package com.daniel.food_order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private String openingHours;
    private int numRating;
    private LocalDateTime registrationDate;
    private boolean open;

    @OneToOne
    private User owner;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Embedded
    private ContactInformation contactInformation;

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    private String status;

}
