package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.dto.UserDto;
import com.mkstower.service.UserDtoService;

@RestController
@RequestMapping("api/v2/users")
public class UserDtoController {
	
	@Autowired
	UserDtoService userDtoService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUserDto(@Validated @RequestBody UserDto userDto) {
		UserDto savedUserDto = userDtoService.createUserDto(userDto);
		return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserDtoById(@PathVariable long id) {
		UserDto user = userDtoService.getUserDtoById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("{id}/address-active")
	public ResponseEntity<UserDto> getUserDtoByIdAndAddress(@PathVariable long id) {
		UserDto user = userDtoService.getUserDtoByIdAndAddressActive(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUserDtos() {
		List<UserDto> users = userDtoService.getAllUsersDto();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("active")
	public ResponseEntity<List<UserDto>> getAllActiveUserDtos() {
		List<UserDto> users = userDtoService.getAllActiveUsersDto();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("inactive")
	public ResponseEntity<List<UserDto>> getAllInactiveUserDtos() {
		List<UserDto> users = userDtoService.getAllInactiveUsersDto();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUserDto(@PathVariable long id, @Validated @RequestBody UserDto userDto) {
		UserDto updateUserDto = userDtoService.updateUserDto(userDto, id);
		return new ResponseEntity<>(updateUserDto, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUserDto(@PathVariable long id) {
		userDtoService.deleteUserDto(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}

}
