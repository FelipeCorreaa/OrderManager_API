package com.noovi2.userdept.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.noovi2.userdept.entities.Category;
import com.noovi2.userdept.entities.OrdenItem;
import com.noovi2.userdept.entities.Order;
import com.noovi2.userdept.entities.Payment;
import com.noovi2.userdept.entities.Product;
import com.noovi2.userdept.entities.User;
import com.noovi2.userdept.entities.enums.OrderStatus;
import com.noovi2.userdept.repositories.CategoryRepository;
import com.noovi2.userdept.repositories.OrderItemRepository;
import com.noovi2.userdept.repositories.OrderRepository;
import com.noovi2.userdept.repositories.PaymentRepository;
import com.noovi2.userdept.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository produtcRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User (null,"Maria Joaquina","Maria@gmail.com","911111111","123456");
		User u2 = new User (null, "Felipe Correa", "felipe@yahoo.com","92222222","78945613");
		userRepository.saveAll(Arrays.asList(u1,u2));//Salvar no banco de dados
		
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"),OrderStatus.CANCELADO , u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"),OrderStatus.PAGO ,u2);
		Order o3 = new Order(null, Instant.parse("2022-08-22T15:21:22Z"),OrderStatus.AGUARDANDO_PAGAMENTO ,u1);
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));//Salvar no banco de dados
		
		
		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));//Salvar no banco de dados
		
		
		
		Product p1 = new Product(null, "Clean code", "Livro boas praticas programação", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Televisão LED 4k", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Produto muito caroooo", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Um sonho de qualquer pessoa", 1200.0, "");
		Product p5 = new Product(null, "Batedeira", "Batedeira para paes.", 100.99, "");
		produtcRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));//Salvar no banco de dados
		
		p1.getCategories().add(cat2);//associação dos produtos com as categorias.
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat1);
		produtcRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrdenItem oi1 = new OrdenItem(o1, p1, 2, p1.getPrice());
		OrdenItem oi2 = new OrdenItem(o1, p3, 1, p3.getPrice());
		OrdenItem oi3 = new OrdenItem(o2, p3, 2, p3.getPrice());
		OrdenItem oi4 = new OrdenItem(o3, p5, 2, p5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		

		Payment pay1 = new Payment (null,Instant.parse("2022-07-21T05:42:10Z"),o2);
		o2.setPayment(pay1);
		orderRepository.save(o2);
		
		
	}
	
	
	
}
