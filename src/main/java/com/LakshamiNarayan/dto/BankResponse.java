package com.LakshamiNarayan.dto;

import com.LakshamiNarayan.dto.AccountInfo.AccountInfoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankResponse {

	private String responseCode;
	private String responseMessage;
	private AccountInfo accountInfo;
	private String access;
}
