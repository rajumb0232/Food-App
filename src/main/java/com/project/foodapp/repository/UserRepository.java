package com.project.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodapp.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserEmail(String userEmail);
}
