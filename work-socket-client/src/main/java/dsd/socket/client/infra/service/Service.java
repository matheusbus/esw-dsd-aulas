/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.service;

import java.util.Map;

/**
 *
 * @author Matheus
 */
public interface Service<T, ID> {
    
    T insert(T entity);
    Map<ID, T> findAll();
    T update(T entity);
    void delete(ID id);
    T find(ID id);
    
}
