package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
