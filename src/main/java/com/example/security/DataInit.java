package com.example.security;

import com.example.security.models.Customer;
import com.example.security.repo.AuthorityRepo;
import com.example.security.repo.CustomerRepository;
import com.example.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthorityRepo authorityRepo;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
       /* User user1= userRepo.save(new User("ayoub","1234",true));
        Authority authority=new Authority("write");
        authority.setUser(user1);
        authorityRepo.save(authority);
                customerRepository.save(new Customer("ayoub@gmail.com",passwordEncoder.encode("12345"),"admin"));

        */


    }
}
