package com.noovi2.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noovi2.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
