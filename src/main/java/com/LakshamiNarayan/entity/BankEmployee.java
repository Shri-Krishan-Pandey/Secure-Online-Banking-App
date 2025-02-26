package com.LakshamiNarayan.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class BankEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
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
	@CreationTimestamp
	private LocalDateTime joinedAt;
}
