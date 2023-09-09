package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
