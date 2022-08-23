package com.example.security;

import com.example.security.model.Customer;
import com.example.security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        Customer customer=new Customer();
        customer.setEmail("ayoub@gmail.com");
        customer.setMobileNumber("0632236881");
        customer.setPwd(passwordEncoder.encode("12345"));
        customerRepository.save(customer);
    }
}
