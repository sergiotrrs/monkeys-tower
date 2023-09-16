package com.mkstower.service;

import java.util.List;

import com.mkstower.entity.User;
import com.mkstower.entity.limits.UserFieldLimits;

public interface UserService extends UserFieldLimits {

	User createUser(User user);
	
	User getUserById(long id);

	User getUserByIdAndActiveAddress(long id);

	User getUserByEmail(String email);
	
	List<User> getAllUsers();
	
	List<User> getAllActiveUsers();
	
	List<User> getAllInactiveUsers();
	
	User updateUser(User user, long id);
	
	void deleteUser(long id);
	
}
