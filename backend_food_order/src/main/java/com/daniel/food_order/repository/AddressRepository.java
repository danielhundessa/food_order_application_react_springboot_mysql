package com.daniel.food_order.repository;

import com.daniel.food_order.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{
}
