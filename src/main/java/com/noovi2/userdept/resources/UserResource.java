package com.noovi2.userdept.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noovi2.userdept.entities.User;
import com.noovi2.userdept.services.Userservice;

@RestController
@RequestMapping (value = "/users")

public class UserResource {
	
	@Autowired
	private Userservice service;
	
	//Get para listar os usuários e todas as info do banco 
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List <User> list = service.FindAll();
		 
		return ResponseEntity.ok() .body(list);
		
	}
	
	//adicionar a chave para procurar por ID
	@GetMapping (value = "/{id}")
	public ResponseEntity <User> findById(@PathVariable Long id){
		User obj= service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}