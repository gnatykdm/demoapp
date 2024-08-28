package com.springapp.model.service;

import com.springapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    void save(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    Customer findCustomerById(Integer id);
    Optional<Customer> findByUsername(String username);
    List<Customer> findAll();
}
