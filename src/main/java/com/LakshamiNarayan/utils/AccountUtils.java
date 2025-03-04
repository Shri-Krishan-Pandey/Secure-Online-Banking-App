package com.LakshamiNarayan.utils;

import java.time.Year;

public class AccountUtils {
	public static final String ACCOUNT_EXISTS_CODE = "001";
	public static final String ACCOUNT_EXISTS_MESSAGE = "THIS USER ALREADY HAS AN ACCOUNT CREATED !!!";
	public static final String ACCOUNT_CREATION_SUCCESS = "002";
	public static final String ACCOUNT_CREATION_MESSAGE="ACCOUNT HAS BEEN SUCCESSFULLY CREATED !!!";
	
	
	public static String geneateAccountNumber() {
		/**
		 * 2023 + randomSixDigits
		 */
		Year currentYear = Year.now();
		int min = 100000;
		int max = 999999;
		//generate a random number between min and max
		int randNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);
		//convert the current and randomNumber to strings, then concatenation
		String year= String.valueOf(currentYear);
		String randomNumber = String.valueOf(randNumber);
		StringBuilder accountNumber = new StringBuilder();
		return accountNumber.append(year).append(randomNumber).toString();
	}

}
