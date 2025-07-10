package com.wisemind8h.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisemind8h.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
