package com.mkstower.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.*;
import com.mkstower.repository.UserRepository;
import com.mkstower.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		if (user.getRoles().isEmpty())
			user.setRoles(new ArrayList<Role>(List.of(new Role(1, "Customer", "Customer"))));

		return saveUser(user);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("User does not exist with id: " + id));		
	}
	
	@Override
	public User getUserByIdAndAddressActive(long id) {
		return userRepository.findByIdAndAddressesActive(id)
				.orElseThrow( ()-> new IllegalStateException ("User does not exist with id: " + id));		
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow( ()-> new IllegalStateException ("User does not exist with email: " + email));		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getAllActiveUsers() {
		return userRepository.findAllByActive(true);
	}
	
	@Override
	public List<User> getAllInactiveUsers() {
		return userRepository.findAllByActive(false);
	}

	@Override
	public User updateUser(User user, long id) {
		User existingUser = getUserById(id);
		existingUser.setFirstname( user.getFirstname());
		existingUser.setLastname( user.getLastname());
		existingUser.setBirthdate(user.getBirthdate());
		existingUser.setAvatar( user.getAvatar());		
		return saveUser(existingUser);
	}

	@Override
	public void deleteUser(long id) {
		User existingUser = getUserById(id);
		existingUser.setActive(false);		
		saveUser(existingUser);
	}

}
