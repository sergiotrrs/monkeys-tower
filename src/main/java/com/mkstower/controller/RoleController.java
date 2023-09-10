package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.Role;
import com.mkstower.service.RoleService;

@RestController
@RequestMapping("api/roles")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping
	public ResponseEntity<Role> createRole(@Validated @RequestBody Role role) {
		Role savedRole = roleService.createRole(role);
		return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable long id) {
		Role role = roleService.getRoleById(id);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> roles = roleService.getAllRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@GetMapping("active")
	public ResponseEntity<List<Role>> getAllActiveRoles() {
		List<Role> roles = roleService.getAllActiveRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Role> updateRole(@PathVariable long id, @Validated @RequestBody Role role) {
		Role updateRole = roleService.updateRole(role, id);
		return new ResponseEntity<>(updateRole, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRole(@PathVariable long id) {
		roleService.deleteRole(id);
		return new ResponseEntity<>("Role id " + id + " successfully deleted", HttpStatus.OK);
	}

}
