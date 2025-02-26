package com.LakshamiNarayan.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LakshamiNarayan.dto.AccountInfo;
import com.LakshamiNarayan.dto.BankResponse;
import com.LakshamiNarayan.dto.EmailDetails;
import com.LakshamiNarayan.dto.UserRequest;
import com.LakshamiNarayan.entity.User;
import com.LakshamiNarayan.repository.UserRepository;
import com.LakshamiNarayan.utils.AccountUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService emailService;

	@Override
	public BankResponse createAccount(UserRequest userRequest) {
		/**
		 * Creating an account - saving a new user into the db
		 * check if user already has an account
		 */
		if(userRepository.existsByEmail(userRequest.getEmail())) {
			return BankResponse.builder()
					.responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
					.responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
					.accountInfo(null)
					.access("Access Denied !!!")
					.build();
			
		}
		User newUser = User.builder()
				.firstName(userRequest.getFirstName())
				.middleName(userRequest.getMiddleName())
				.lastName(userRequest.getLastName())
				.gender(userRequest.getGender())
				.address(userRequest.getAddress())
				.state(userRequest.getState())
				.accountNumber(AccountUtils.geneateAccountNumber())
				.accountBalance(BigDecimal.ZERO)
				.email(userRequest.getEmail())
				.phoneNumber(userRequest.getPhoneNumber())
				.alternatePhoneNumber(userRequest.getAlternatePhoneNumber())
				.status("ACTIVE")
				.build();
		
		User savedUser = userRepository.save(newUser);
		//send email Alert
		EmailDetails emailDetails = EmailDetails.builder()
				.recipient(savedUser.getEmail())
				.subject("ACCOUNT CREATION")
				.messageBody("Congratulations! Your Account has been Successfully Created.\nYour Account Details: \n"
						+ "Account Name: " + savedUser.getFirstName() + " " + savedUser.getMiddleName() + " " +savedUser.getLastName()
						+ "\nAccount Number : " + savedUser.getAccountNumber())
				.build();
		emailService.sendEmailAlert(emailDetails);
		return BankResponse.builder()
				.access("Successfully Registered !!!")
				.responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
				.responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
				.accountInfo(AccountInfo.builder()
						.accountBalance(savedUser.getAccountBalance())
						.accountNumber(savedUser.getAccountNumber())
						.accountName(savedUser.getFirstName() + " " + savedUser.getMiddleName() + " " + savedUser.getLastName())
						.build())
				.build();
	}
	
}
