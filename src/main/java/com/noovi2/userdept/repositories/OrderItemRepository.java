package com.noovi2.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noovi2.userdept.entities.OrdenItem;

public interface OrderItemRepository extends JpaRepository<OrdenItem, Long> {

	
	
}
