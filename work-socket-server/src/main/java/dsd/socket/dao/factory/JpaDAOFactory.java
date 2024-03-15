package dsd.socket.dao.factory;

import dsd.socket.dao.DAO;
import dsd.socket.dao.impl.CompanyJpaDAOImpl;
import dsd.socket.dao.impl.CustomerJpaDAOImpl;
import dsd.socket.dao.impl.EmployeeJpaDAOImpl;
import dsd.socket.dao.impl.PersonJpaDAOImpl;
import dsd.socket.domain.Company;
import dsd.socket.domain.Customer;
import dsd.socket.domain.Employee;
import dsd.socket.domain.Person;

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
