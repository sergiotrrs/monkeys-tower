package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.User;
import com.mkstower.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
		User savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("{id}/address-active")
	public ResponseEntity<User> getUserByIdAndAddress(@PathVariable long id) {
		User user = userService.getUserByIdAndAddressActive(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("active")
	public ResponseEntity<List<User>> getAllActiveUsers() {
		List<User> users = userService.getAllActiveUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("inactive")
	public ResponseEntity<List<User>> getAllInactiveUsers() {
		List<User> users = userService.getAllInactiveUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @Validated @RequestBody User user) {
		User updateUser = userService.updateUser(user, id);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}

}
