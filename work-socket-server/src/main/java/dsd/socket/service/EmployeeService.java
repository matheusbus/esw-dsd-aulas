package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Employee;

public class EmployeeService {
    
    private final DAO<Employee, String> dao;

    public EmployeeService(DAO<Employee, String> dao) {
        this.dao = dao;
    }
    
}
