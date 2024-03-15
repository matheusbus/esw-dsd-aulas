package dsd.socket.dao.impl;

import dsd.socket.dao.JpaDAO;
import dsd.socket.domain.Employee;

public class EmployeeJpaDAOImpl extends JpaDAO<Employee, String> {

    public EmployeeJpaDAOImpl() {
        super(Employee.class);
    }
    
}
