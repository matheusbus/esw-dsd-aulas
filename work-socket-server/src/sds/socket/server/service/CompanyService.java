/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.service;

import sds.socket.server.dao.DAO;
import sds.socket.server.domain.Company;

/**
 *
 * @author matheus.buschermoehl
 */
public class CompanyService {
    
    private final DAO<Company, Integer> dao;

    public CompanyService(DAO<Company, Integer> dao) {
        this.dao = dao;
    }
    
    
    
}
