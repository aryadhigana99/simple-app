package com.example.mys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mys.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	private final AccountRepository accountRepository;
	
	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
