package com.syrovets.customertracker.dao.implementation;

import com.syrovets.customertracker.dao.CustomerDAO;
import com.syrovets.customertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getObject().getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }
}
