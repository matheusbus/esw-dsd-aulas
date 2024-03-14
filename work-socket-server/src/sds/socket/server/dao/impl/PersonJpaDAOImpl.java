/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao.impl;

import sds.socket.server.dao.JpaDAO;
import sds.socket.server.domain.Person;

/**
 *
 * @author matheus.buschermoehl
 */
public class PersonJpaDAOImpl extends JpaDAO<Person, String> {

    public PersonJpaDAOImpl() {
        super(Person.class);
    }
    
}
