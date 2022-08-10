package com.noovi2.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noovi2.userdept.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	
}
