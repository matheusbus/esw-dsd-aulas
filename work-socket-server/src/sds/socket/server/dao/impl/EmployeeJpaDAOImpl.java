/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao.impl;

import sds.socket.server.dao.JpaDAO;
import sds.socket.server.domain.Employee;

/**
 *
 * @author matheus.buschermoehl
 */
public class EmployeeJpaDAOImpl extends JpaDAO<Employee, String> {

    public EmployeeJpaDAOImpl() {
        super(Employee.class);
    }
    
}
