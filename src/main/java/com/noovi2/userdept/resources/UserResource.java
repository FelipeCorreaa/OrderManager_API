package com.noovi2.userdept.resources;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletSecurityElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping //Realizar o Post com os dados do usuário obj
	public ResponseEntity<User> insert (@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();//adicionand a resposta de criação com resposta 201 Crated
		return ResponseEntity.created(uri).body(obj); // 
		
		
	}
	
	
}
