package com.noovi2.userdept.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noovi2.userdept.entities.User;
import com.noovi2.userdept.repositories.UserRepository;
import com.noovi2.userdept.services.exceptions.ResourceNotFoundException;

@Service
public class Userservice {
	
	//Listar os usuários do repositório do banco de dados.
	@Autowired
	private UserRepository repository;
	
	public List <User> FindAll (){
		return repository.findAll();
			
	}
	
	
	// buscar usuário pelo ID
	public User findById (Long id) {
		Optional <User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new  ResourceNotFoundException(id)); //adicionando a exceção por ID quando não for encontrado
	}
	
	
	//adicionar um novo objeto do tipo user no banco de dados
	public User insert (User obj) {
		return repository.save(obj);
		
	}


	public void delete (Long id) {
		repository.deleteById(id);
		
	}
	
	
	public User update (Long id , User obj) {
		try {
		User entity = repository.getOne(id); // getone ele prepara o objeto antes de salvar.
		
		updateData (entity,obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
			
		}
	}


	private void updateData(User entity, User obj) {
		//atualizar os dados do entity com os campos do obj
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
