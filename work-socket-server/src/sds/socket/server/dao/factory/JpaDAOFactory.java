/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao.factory;

import sds.socket.server.dao.DAO;
import sds.socket.server.dao.impl.CompanyJpaDAOImpl;
import sds.socket.server.dao.impl.CustomerJpaDAOImpl;
import sds.socket.server.dao.impl.EmployeeJpaDAOImpl;
import sds.socket.server.dao.impl.PersonJpaDAOImpl;
import sds.socket.server.domain.Company;
import sds.socket.server.domain.Customer;
import sds.socket.server.domain.Employee;
import sds.socket.server.domain.Person;

/**
 *
 * @author matheus.buschermoehl
 */
public class JpaDAOFactory implements DAOFactory {

    @Override
    public DAO<Company, Integer> createCompanyDAO() {
        return new CompanyJpaDAOImpl();
    }

    @Override
    public DAO<Customer, String> createCustomerDAO() {
        return new CustomerJpaDAOImpl();
    }

    @Override
    public DAO<Employee, String> createEmployeeDAO() {
        return new EmployeeJpaDAOImpl();
    }

    @Override
    public DAO<Person, String> createPersonDAO() {
        return new PersonJpaDAOImpl();
    }
    
}
