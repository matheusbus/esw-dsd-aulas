/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao.factory;

import sds.socket.server.dao.DAO;
import sds.socket.server.domain.Company;
import sds.socket.server.domain.Customer;
import sds.socket.server.domain.Employee;
import sds.socket.server.domain.Person;

/**
 *
 * @author matheus.buschermoehl
 */
public interface DAOFactory {
    
    DAO<Company, Integer> createCompanyDAO();
    DAO<Customer, String> createCustomerDAO();
    DAO<Employee, String> createEmployeeDAO();
    DAO<Person, String> createPersonDAO();
    
}
