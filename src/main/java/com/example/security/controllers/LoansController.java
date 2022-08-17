package com.example.security.controllers;

import java.util.List;

import com.example.security.models.Customer;
import com.example.security.models.Loans;
import com.example.security.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoansController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(Math.toIntExact(customer.getId()));
		if (loans != null ) {
			return loans;
		}else {
			return null;
		}
	}

}
