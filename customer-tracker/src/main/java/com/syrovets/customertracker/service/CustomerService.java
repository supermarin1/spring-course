package com.syrovets.customertracker.service;

import com.syrovets.customertracker.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void delete(int id);
}
