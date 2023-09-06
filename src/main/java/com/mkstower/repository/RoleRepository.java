package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
