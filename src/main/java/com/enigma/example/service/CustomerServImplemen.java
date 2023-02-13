package com.enigma.example.service;

import com.enigma.example.entity.Customer;
import com.enigma.example.entity.Product;
import com.enigma.example.repository.CustomerRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServImplemen implements CustomerService {
    CustomerRepo customerRepo;

    public CustomerServImplemen(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> data = customerRepo.findAll();
//        data.stream().filter(e -> e.getProductPrice() > 2000);

        return data;
    }

    @Override
    public Customer getById(String id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer saveNew(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> getCustPerPage(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }
}
