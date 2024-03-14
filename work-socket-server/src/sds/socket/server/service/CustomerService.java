/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.service;

import sds.socket.server.dao.DAO;
import sds.socket.server.domain.Customer;

/**
 *
 * @author matheus.buschermoehl
 */
public class CustomerService {
    
    private final DAO<Customer, String> dao;

    public CustomerService(DAO<Customer, String> dao) {
        this.dao = dao;
    }
    
}
