package com.wisemind8h.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wisemind8h.course.entities.Order;
import com.wisemind8h.course.entities.User;
import com.wisemind8h.course.entities.enums.OrderStatus;
import com.wisemind8h.course.repositories.OrderRepository;
import com.wisemind8h.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    private final OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

    TestConfig(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

	@Override
	public void run(String... args) throws Exception {
		 
		User u1 = new User(null, "Maria BROWN", "maria@gmail.com", "1234321", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "12348765", "12345");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
