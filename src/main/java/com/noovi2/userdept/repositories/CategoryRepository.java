package com.noovi2.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noovi2.userdept.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	
}
