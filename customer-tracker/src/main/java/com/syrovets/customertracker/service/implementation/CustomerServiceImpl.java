package com.syrovets.customertracker.service.implementation;

import com.syrovets.customertracker.dao.CustomerDAO;
import com.syrovets.customertracker.entity.Customer;
import com.syrovets.customertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDao;


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        customerDao.delete(id);
    }
}
