package com.LakshamiNarayan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LakshamiNarayan.dto.EmployeeCheck;
import com.LakshamiNarayan.dto.EmployeeResponse;
import com.LakshamiNarayan.entity.BankEmployee;
import com.LakshamiNarayan.entity.Employee;
import com.LakshamiNarayan.repository.EmployeeRepository;
import com.LakshamiNarayan.utils.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public EmployeeResponse createId(Employee em) {
		if(employeeRepository.existsByEmailAndPassword(em.getEmail(),em.getPassword())){
			return EmployeeResponse.builder()
					.responseCode(EmployeeUtils.ACCOUNT_ALREADY_EXISTS_CODE)
					.build();
		}
		BankEmployee newEmployee = BankEmployee.builder()
				.firstName(em.getFirstName())
				.middleName(em.getMiddleName())
				.lastName(em.getLastName())
				.gender(em.getGender())
				.address(em.getAddress())
				.state(em.getState())
				.email(em.getEmail())
				.password(em.getPassword())
				.re_Password(em.getRe_Password())
				.phoneNumber(em.getPhoneNumber())
				.altenatePhoneNumber(em.getAltenatePhoneNumber())
				
				.build();
		BankEmployee savedEmployee = employeeRepository.save(newEmployee);
		return EmployeeResponse.builder()
				.successMessage(EmployeeUtils.ACCOUNT_SUCCESS_MESSAGE)
				.build();
		
	}
	public Boolean check(EmployeeCheck empCheck) {
		return employeeRepository.existsByEmailAndPassword(empCheck.getEmail(), empCheck.getPassword());
	}
}
