package com.syrovets.customertracker.service;

import com.syrovets.customertracker.dao.CustomerDAO;
import com.syrovets.customertracker.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

}
