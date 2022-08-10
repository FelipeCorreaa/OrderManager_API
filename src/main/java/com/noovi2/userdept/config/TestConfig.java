package com.noovi2.userdept.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.noovi2.userdept.entities.Category;
import com.noovi2.userdept.entities.Order;
import com.noovi2.userdept.entities.User;
import com.noovi2.userdept.entities.enums.OrderStatus;
import com.noovi2.userdept.repositories.CategoryRepository;
import com.noovi2.userdept.repositories.OrderRepository;
import com.noovi2.userdept.repositories.UserRepository;
//CLASSE PARA TESTES DO BANCO DE DADOS PARA INICIAR ARQUIVOS NO BD
@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User (null,"Maria Joaquina","Maria@gmail.com","911111111","123456");
		User u2 = new User (null, "Felipe Correa", "felipe@yahoo.com","92222222","78945613");
		userRepository.saveAll(Arrays.asList(u1,u2));//Salvar no banco de dados
		
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"),OrderStatus.CANCELED , u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"),OrderStatus.PAID ,u2);
		Order o3 = new Order(null, Instant.parse("2022-08-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT ,u1);
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));//Salvar no banco de dados
		
		
		Category cat1 = new Category(null, "PS5");
		Category cat2 = new Category(null, "Computador");
		Category cat3 = new Category(null, "Celular");
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));//Salvar no banco de dados
		
		
	
	}
	
	
	
}
