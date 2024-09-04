package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Accounts;
import com.nit.repository.AccountsRepository;

@RestController
public class AccountController {
	
	@Autowired
	public AccountsRepository accountsRepository;
	
	@GetMapping("/myAccount")
	public Accounts getAccountDetails(@RequestParam int id) {
		Accounts accounts = accountsRepository.findByCustomerId(id);
		if(accounts != null)
			return accounts;
		else
			return null;
	}
}
