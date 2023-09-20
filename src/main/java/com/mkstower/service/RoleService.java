package com.mkstower.service;

import java.util.List;

import com.mkstower.entity.Role;
import com.mkstower.entity.limits.RoleFieldLimits;

public interface RoleService extends RoleFieldLimits {

	Role createRole(Role role);
	
	Role getRoleById(long id);
	
	List<Role> getAllRoles();
	
	Role updateRole(Role role, long id);
	
	void deleteRole(long id);
	
}
