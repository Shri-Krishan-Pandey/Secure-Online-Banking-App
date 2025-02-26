package com.LakshamiNarayan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LakshamiNarayan.entity.BankEmployee;




@Repository
public interface EmployeeRepository extends JpaRepository<BankEmployee, Long> {
	public Boolean existsByEmailAndPassword(String email, String password);

}
