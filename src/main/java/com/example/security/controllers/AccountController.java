package com.example.security.controllers;

import com.example.security.models.Accounts;
import com.example.security.models.Customer;
import com.example.security.repo.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts accounts = accountsRepository.findByCustomerId(Math.toIntExact(customer.getId()));
		if (accounts != null ) {
			return accounts;
		}else {
			return null;
		}
	}

}
