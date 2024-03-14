/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao;

import java.util.List;

/**
 *
 * @author matheus.buschermoehl
 */
public interface DAO<T, ID> {
    
    T insert(T entity);
    List<T> findAll();
    T update(T entity);
    void delete(ID id);
    T find(ID id);
    
}
