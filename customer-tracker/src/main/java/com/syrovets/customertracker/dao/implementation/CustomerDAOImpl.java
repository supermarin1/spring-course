package com.syrovets.customertracker.dao.implementation;

import com.syrovets.customertracker.dao.CustomerDAO;
import com.syrovets.customertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getObject().getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }
}
