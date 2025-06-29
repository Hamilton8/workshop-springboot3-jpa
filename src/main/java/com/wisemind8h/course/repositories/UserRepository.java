package com.wisemind8h.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisemind8h.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
