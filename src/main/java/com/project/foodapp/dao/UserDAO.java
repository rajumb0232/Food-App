package com.project.foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.User;
import com.project.foodapp.repository.UserRepository;

@Repository
public class UserDAO {
	
	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User findUser(long userId) {
		Optional<User> optional = userRepo.findById(userId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public User updateUser(User user, long userId) {
		Optional<User> optional = userRepo.findById(userId);
		if(optional.isEmpty()) {
			return null;
		}
		user.setUserId(userId);
	return	userRepo.save(user);
	}
	
	public User deleteUser(long userId) {
		Optional<User> optional = userRepo.findById(userId);
		if(optional.isEmpty()) {
			return null;
		}
		 userRepo.delete(optional.get());
		 return optional.get();
	}
	
	public User findUserByEmail(String userEmail) {
		User user = userRepo.findByUserEmail(userEmail);
		if(user!=null) {
			return user;
		}
		return null;
	}
}
