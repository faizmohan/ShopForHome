package com.shop.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.User;

public interface UserRespository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
//	Optional<User> findByEmail(String email);
}
