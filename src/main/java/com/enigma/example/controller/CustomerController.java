package com.enigma.example.controller;

import com.enigma.example.entity.Customer;
import com.enigma.example.entity.Product;
import com.enigma.example.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    CustomerService custService;

    public CustomerController(CustomerService custService) {
        this.custService = custService;
    }

    @GetMapping("/{id}")
    public Customer getDataCustomer(@PathVariable String id){
        return custService.getById(id);
    }

    @PostMapping
    public Customer createProduct(@RequestBody Customer cust) {
        return custService.saveNew(cust);
    }

    @PutMapping
    public void updateProduct(@RequestBody Customer cust) {
        custService.saveNew(cust);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam String id) {
        custService.delete(id);
    }

    @GetMapping
    public Page<Customer> getPagination(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", defaultValue = "3      ") Integer sizePerPage){
        Pageable pageable = PageRequest.of(page, sizePerPage);
        return custService.getCustPerPage(pageable);
    }


}
