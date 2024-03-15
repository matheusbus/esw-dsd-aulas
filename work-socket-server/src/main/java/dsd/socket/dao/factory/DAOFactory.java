package dsd.socket.dao.factory;


import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.domain.Customer;
import dsd.socket.domain.Employee;
import dsd.socket.domain.Person;

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
