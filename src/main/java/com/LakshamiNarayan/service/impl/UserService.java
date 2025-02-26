package com.LakshamiNarayan.service.impl;

import com.LakshamiNarayan.dto.BankResponse;
import com.LakshamiNarayan.dto.UserRequest;

public interface UserService {

	BankResponse createAccount(UserRequest userRequest);
}
