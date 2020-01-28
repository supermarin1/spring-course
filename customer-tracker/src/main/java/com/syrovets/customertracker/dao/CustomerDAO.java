package com.syrovets.customertracker.dao;

import com.syrovets.customertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
