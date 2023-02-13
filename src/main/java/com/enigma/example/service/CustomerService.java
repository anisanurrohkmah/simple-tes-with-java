package com.enigma.example.service;

import com.enigma.example.entity.Customer;
import com.enigma.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();
    public Customer getById(String id);
    public Customer saveNew(Customer customer);
    public void delete(String id);
    public  Page<Customer> getCustPerPage(Pageable pageable);

}


