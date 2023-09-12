package com.mkstower.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAllByActive(boolean active);
	
	Optional<User> findByEmail(String email);

}
