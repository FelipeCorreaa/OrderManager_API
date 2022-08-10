package com.noovi2.userdept.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noovi2.userdept.entities.Product;
import com.noovi2.userdept.repositories.ProductRepository;

@Service
public class Productservice {
	
	//Listar os usuários do repositório do banco de dados.
	@Autowired
	private ProductRepository repository;
	
	public List <Product> FindAll (){
		return repository.findAll();
			
	}
	
	
	// buscar usuário pelo ID
	public Product findById (Long id) {
		Optional <Product> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
