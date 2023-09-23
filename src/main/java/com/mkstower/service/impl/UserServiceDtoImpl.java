package com.mkstower.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.dto.UserDto;
import com.mkstower.entity.*;
import com.mkstower.repository.UserRepository;
import com.mkstower.service.UserService;
import com.mkstower.service.UserDtoService;

@Service
public class UserServiceDtoImpl implements UserDtoService {
	
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserService userService;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public UserDto createUserDto(UserDto userDto) {
		User userMapper = userDtoToUser(userDto);
		User newUser = userService.createUser(userMapper);
	    return userToUserDto(newUser);		
	}

	@Override
	public UserDto getUserDtoById(long id) {
		User existingUser = userService.getUserById(id);
		return userToUserDto(existingUser);
	}
	
	@Override
	public UserDto getUserDtoByIdAndAddressActive(long id) {
		User existingUser = userService.getUserByIdAndAddressActive(id);
		return userToUserDto(existingUser);
	}

	public UserDto userToUserDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}
	
	public User userDtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}
	
	public List<UserDto> usersToUsersDto(List<User> users){
		return users.stream()
				.map( user -> userToUserDto(user))
				.toList();
	}
	
	@Override
	public UserDto getUserDtoByEmail(String email) {
		User existingUser = userService.getUserByEmail(email);
		return userToUserDto(existingUser);
	}

	@Override
	public List<UserDto> getAllUsersDto() {
		List<User> users = userService.getAllUsers();
		return usersToUsersDto(users);						
	}

	@Override
	public List<UserDto> getAllActiveUsersDto() {
		List<User> users = userService.getAllActiveUsers();
		return usersToUsersDto(users);
	}
	
	@Override
	public List<UserDto> getAllInactiveUsersDto() {
		List<User> users = userService.getAllInactiveUsers();
		return usersToUsersDto(users);
	}

	@Override
	public UserDto updateUserDto(UserDto user, long id) {		
		User existingUser = userService.getUserById(id);
		existingUser.setFirstname( user.getFirstname());
		existingUser.setLastname( user.getLastname());
		existingUser.setBirthdate(user.getBirthdate());
		existingUser.setAvatar( user.getAvatar());		
		return userToUserDto( userService.createUser(existingUser));  
	}

	@Override
	public void deleteUserDto(long id) {
		userService.deleteUser(id);
	}

}
