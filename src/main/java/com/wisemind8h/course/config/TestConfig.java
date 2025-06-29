package com.wisemind8h.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wisemind8h.course.entities.User;
import com.wisemind8h.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		 
		User u1 = new User(null, "Maria BROWN", "maria@gmail.com", "1234321", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "12348765", "12345");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
