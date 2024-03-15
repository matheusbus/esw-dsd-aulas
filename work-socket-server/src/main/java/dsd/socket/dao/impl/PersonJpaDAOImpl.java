package dsd.socket.dao.impl;

import dsd.socket.dao.JpaDAO;
import dsd.socket.domain.Person;

public class PersonJpaDAOImpl extends JpaDAO<Person, String> {

    public PersonJpaDAOImpl() {
        super(Person.class);
    }
    
}
