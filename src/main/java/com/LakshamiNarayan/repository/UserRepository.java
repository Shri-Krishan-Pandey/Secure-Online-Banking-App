package com.LakshamiNarayan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LakshamiNarayan.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Boolean existsByEmail(String email);
//	Boolean existsByAccountNumber

}
