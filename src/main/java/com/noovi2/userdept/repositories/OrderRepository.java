package com.noovi2.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noovi2.userdept.entities.Order;
import com.noovi2.userdept.entities.Payment;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
}
