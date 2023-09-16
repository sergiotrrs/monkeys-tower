package com.mkstower.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkstower.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAllByActive(boolean active);
	
	Optional<User> findByEmail(String email);
	
	//Optional<User> findByIdAndAddressesActive(long id, boolean statusAddress);
    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.addresses a WHERE u.id = :userId AND (a.active = true OR a.id IS NULL)")
    Optional<User> findByIdAndAddressesActive(@Param("userId") long userId);

}
