package com.wisemind8h.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wisemind8h.course.entities.Category;
import com.wisemind8h.course.entities.Order;
import com.wisemind8h.course.entities.Product;
import com.wisemind8h.course.entities.User;
import com.wisemind8h.course.entities.enums.OrderStatus;
import com.wisemind8h.course.repositories.CategoryRepository;
import com.wisemind8h.course.repositories.OrderRepository;
import com.wisemind8h.course.repositories.ProductRepository;
import com.wisemind8h.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

    TestConfig(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

	@Override
	public void run(String... args) throws Exception {
		 
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product prod1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5, " ");
		Product prod2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0," ");
		Product prod3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0," ");
		Product prod4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0," ");
		Product prod5 = new Product(null, "Rails for Dumies", "Cras fringilla convallis sem vel faucibus", 100.99, " " );
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		
		
		prod1.getCategories().add(cat2);
		prod2.getCategories().add(cat1);
		prod2.getCategories().add(cat3);
		prod3.getCategories().add(cat3);
		prod4.getCategories().add(cat3);
		prod5.getCategories().add(cat2); 
		
		productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		
		
		User u1 = new User(null, "Maria BROWN", "maria@gmail.com", "1234321", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "12348765", "12345");
		User elidio = new User(null, "Elidio Nuvunga","sozinho@gmail.com", "739656789", "12345" );
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2,elidio));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
}
