package com.example.security.config;

import com.example.security.models.Customer;
import com.example.security.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class NewAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findCustomerByEmail(username);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
