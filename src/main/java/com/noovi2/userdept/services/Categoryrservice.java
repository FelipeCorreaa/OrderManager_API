package com.noovi2.userdept.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noovi2.userdept.entities.Category;
import com.noovi2.userdept.repositories.CategoryRepository;

@Service
public class Categoryrservice {
	
	//Listar os usuários do repositório do banco de dados.
	@Autowired
	private CategoryRepository repository;
	
	public List <Category> FindAll (){
		return repository.findAll();
			
	}
	
	
	// buscar usuário pelo ID
	public Category findById (Long id) {
		Optional <Category> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
