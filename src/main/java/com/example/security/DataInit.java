package com.example.security;

import com.example.security.models.Authority;
import com.example.security.models.Customer;
import com.example.security.models.User;
import com.example.security.repo.AuthorityRepo;
import com.example.security.repo.CustomerRepo;
import com.example.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthorityRepo authorityRepo;

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public void run(String... args) throws Exception {
       /* User user1= userRepo.save(new User("ayoub","1234",true));
        Authority authority=new Authority("write");
        authority.setUser(user1);
        authorityRepo.save(authority);
        */

        customerRepo.save(new Customer("ayoub@gmail.com","1234","admin"));

    }
}
