package dsd.socket.dao.impl;

import dsd.socket.dao.JpaDAO;
import dsd.socket.domain.Customer;

public class CustomerJpaDAOImpl extends JpaDAO<Customer, String> {

    public CustomerJpaDAOImpl() {
        super(Customer.class);
    }
    
}
