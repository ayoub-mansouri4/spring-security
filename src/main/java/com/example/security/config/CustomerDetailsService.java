package com.example.security.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.model.*;
import com.example.security.repository.*;

@Service
public class  CustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> customer = customerRepository.findByEmail(username);
		if (customer.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		}
		return new CustomerDetails(customer.get(0));
	}

}
