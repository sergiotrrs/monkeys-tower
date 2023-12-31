package com.mkstower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	List<Address> findAllByActive(boolean active);
		
}
