package com.example.security.controllers;

import java.util.List;

import com.example.security.models.AccountTransactions;
import com.example.security.models.Customer;
import com.example.security.repo.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BalanceController {

	@Autowired
	private AccountTransactionsRepository accountTransactionsRepository;
	
	@PostMapping("/myBalance")
	public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
		List<AccountTransactions> accountTransactions = accountTransactionsRepository.
				findByCustomerIdOrderByTransactionDtDesc(Math.toIntExact(customer.getId()));
		if (accountTransactions != null ) {
			return accountTransactions;
		}else {
			return null;
		}
	}
}
