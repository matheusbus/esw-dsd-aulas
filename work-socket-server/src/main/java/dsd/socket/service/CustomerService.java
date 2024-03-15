package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Customer;

public class CustomerService {
    
    private final DAO<Customer, String> dao;

    public CustomerService(DAO<Customer, String> dao) {
        this.dao = dao;
    }
    
}
