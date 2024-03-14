/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.service;

import sds.socket.server.dao.DAO;
import sds.socket.server.domain.Employee;

/**
 *
 * @author matheus.buschermoehl
 */
public class EmployeeService {
    
    private final DAO<Employee, String> dao;

    public EmployeeService(DAO<Employee, String> dao) {
        this.dao = dao;
    }
    
}
