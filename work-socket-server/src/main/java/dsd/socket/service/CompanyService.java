package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;

public class CompanyService {
    
    private final DAO<Company, Integer> dao;

    public CompanyService(DAO<Company, Integer> dao) {
        this.dao = dao;
    }
    
    
    
}
