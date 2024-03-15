package dsd.socket.dao.impl;

import dsd.socket.dao.JpaDAO;
import dsd.socket.domain.Company;

public class CompanyJpaDAOImpl extends JpaDAO<Company, Integer> {

    public CompanyJpaDAOImpl() {
        super(Company.class);
    }
}
