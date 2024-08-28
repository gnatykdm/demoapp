package com.springapp.model.service;

import com.springapp.model.Customer;
import com.springapp.model.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerJPA;
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Override
    public void save(Customer customer) {
        if (customer == null) {
            logger.error("Customer is null. Cannot save.");
        }
        customerJPA.save(customer);
    }

    @Override
    public void update(Customer customer) {
        if (customer == null) {
            logger.error("Customer is null. Cannot update.");
        }
        customerJPA.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        if (customer == null) {
            logger.error("Customer is null. Cannot delete.");
        }
        customerJPA.delete(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        if (id == null) {
            logger.error("Id is null. Cannot find customer.");
        }
        return customerJPA.findById(id).orElse(null);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        if (username == null) {
            logger.error("Username is null. Cannot find customer.");
        }
        return customerJPA.findByUsername(username);
    }

    @Override
    public List<Customer> findAll() {
        return customerJPA.findAll();
    }
}
