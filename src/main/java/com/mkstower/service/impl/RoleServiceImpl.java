package com.mkstower.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Role;
import com.mkstower.repository.RoleRepository;
import com.mkstower.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {		
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(long id) {
		return roleRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("Role does not exist with id: " + id));		
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public List<Role> getAllActiveRoles() {
		// return roleRepository.findAll();
		List<Role> roles = new ArrayList<>();
		roles.add(new Role());
		return roles;
	}

	@Override
	public Role updateRole(Role role, long id) {
		Role existingRole = getRoleById(id);
		existingRole.setName( role.getName());

		return createRole(existingRole);
	}

	@Override
	public void deleteRole(long id) {
		Role existingRole = getRoleById(id);
		roleRepository.delete(existingRole);		
	}

}
