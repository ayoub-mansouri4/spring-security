package com.example.security.config;

import com.example.security.models.Customer;
import com.example.security.models.SecurityCustomer;
import com.example.security.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customer = customerRepository.findCustomerByEmail(username);
        if (customer.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        }
        return new SecurityCustomer(customer.get(0));
    }
}
