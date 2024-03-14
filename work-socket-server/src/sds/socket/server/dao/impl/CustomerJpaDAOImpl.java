/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao.impl;

import sds.socket.server.dao.JpaDAO;
import sds.socket.server.domain.Customer;

/**
 *
 * @author matheus.buschermoehl
 */
public class CustomerJpaDAOImpl extends JpaDAO<Customer, String>{

    public CustomerJpaDAOImpl() {
        super(Customer.class);
    }
    
}
