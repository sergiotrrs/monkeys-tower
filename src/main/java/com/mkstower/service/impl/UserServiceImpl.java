package com.mkstower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.User;
import com.mkstower.repository.UserRepository;
import com.mkstower.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("User does not exist with id: " + id));		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getAllActiveUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user, long id) {
		User existingUser = getUserById(id);
		existingUser.setFirstname( user.getFirstname());
		existingUser.setLastname( user.getLastname());
		existingUser.setAvatar( user.getAvatar());
		return createUser(existingUser);
	}

	@Override
	public void deleteUser(long id) {
		User existingUser = getUserById(id);
		existingUser.setActive(false);		
	}

}
