package com.example.security.repo;

import com.example.security.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    List<Customer> findCustomerByEmail(String email);
}
