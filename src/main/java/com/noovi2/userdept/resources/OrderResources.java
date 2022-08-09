package com.noovi2.userdept.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noovi2.userdept.entities.Order;
import com.noovi2.userdept.services.Orderrservice;


@RestController
@RequestMapping (value = "/orders")

public class OrderResources {
	
	
		@Autowired
		private Orderrservice service;
		
		@GetMapping
		public ResponseEntity<List<Order>> findAll(){
			List <Order> list = service.FindAll();
			return ResponseEntity.ok().body(list);
		}

		
		//buscar itens por id
		@GetMapping (value = "/{id}")
		public ResponseEntity<Order> findById(@PathVariable Long id){
			Order obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
			
		}
		
		
		
}
