package com.noovi2.userdept.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noovi2.userdept.entities.Product;
import com.noovi2.userdept.services.Productservice;



@RestController
@RequestMapping (value = "/products")

public class ProductResources {
	
	
		@Autowired
		private Productservice service;
		
		@GetMapping
		public ResponseEntity<List<Product>> findAll(){
			List <Product> list = service.FindAll();
			return ResponseEntity.ok().body(list);
		}

		
		//buscar itens por id
		@GetMapping (value = "/{id}")
		public ResponseEntity<Product> findById(@PathVariable Long id){
			Product obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
			
		}
		
		
		
}
