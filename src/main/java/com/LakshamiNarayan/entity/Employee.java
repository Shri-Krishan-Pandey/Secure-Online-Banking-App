package com.LakshamiNarayan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String address;
	private String state;
	private String email;
	private String password;
	private String re_Password;
	private String phoneNumber;
	private String altenatePhoneNumber;
}
