package com.LakshamiNarayan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LakshamiNarayan.dto.BankResponse;
import com.LakshamiNarayan.dto.EmployeeCheck;
import com.LakshamiNarayan.dto.EmployeeResponse;
import com.LakshamiNarayan.dto.UserRequest;
import com.LakshamiNarayan.entity.BankEmployee;
import com.LakshamiNarayan.entity.Employee;
import com.LakshamiNarayan.service.impl.EmployeeService;
import com.LakshamiNarayan.service.impl.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/")
	public String login() {
		return "EmployeeLogin";
	}
	@PostMapping("/login")
	public String check(@ModelAttribute EmployeeCheck empCheck) {
		Boolean b = employeeService.check(empCheck);
		if(b!=false) {
			return "newUserPage";
			
		}
		else {
			return "redirect:/";
		}
	}
	@GetMapping("/back")
	public String back() {
		return "newUserPage";
	}
	@GetMapping("/newEmployee")
	public String newE() {
		return "newEmployee";
	}
	@PostMapping("/register")
	public String success(@ModelAttribute Employee b, Model model) {
		EmployeeResponse be = employeeService.createId(b);
		model.addAttribute("be",be);
		return "sucPage";
	}
	@GetMapping("/api")
	public String firstPage() {
		return "newUserPage";
	}
	@PostMapping("/user")
	public String createAccount(@ModelAttribute UserRequest userRequest,Model model) {
		BankResponse b = userService.createAccount(userRequest);
		model.addAttribute("b",b);
		String notAllowed = "Not Allowed";
		model.addAttribute("notAllowed", notAllowed);
		return "successPage";
	}
}
