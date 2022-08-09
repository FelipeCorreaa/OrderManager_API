package com.noovi2.userdept.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noovi2.userdept.entities.Order;
import com.noovi2.userdept.repositories.OrderRepository;

@Service
public class Orderrservice {
	
	//Listar os usuários do repositório do banco de dados.
	@Autowired
	private OrderRepository repository;
	
	public List <Order> FindAll (){
		return repository.findAll();
			
	}
	
	
	// buscar usuário pelo ID
	public Order findById (Long id) {
		Optional <Order> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
