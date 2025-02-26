package com.LakshamiNarayan.service.impl;

import com.LakshamiNarayan.dto.EmployeeCheck;
import com.LakshamiNarayan.dto.EmployeeResponse;
import com.LakshamiNarayan.entity.Employee;




public interface EmployeeService {

	EmployeeResponse createId(Employee employee);
	public Boolean check(EmployeeCheck emp);
	
}
