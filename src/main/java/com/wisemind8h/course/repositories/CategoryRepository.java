package com.wisemind8h.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisemind8h.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
