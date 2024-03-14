/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author matheus.buschermoehl
 */
public abstract class JpaDAO<T, ID> implements DAO<T, ID> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<T> clazz;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("h2Unit");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JpaDAO() {
    }

    public JpaDAO(Class<T> clazz) {
        this.clazz = clazz;
        em = emf.createEntityManager();
    }

    @Override
    public T insert(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return findAllOffSet(-1, 0);
    }

    public List<T> findAllOffSet(int quantity, int offset) {
        if (clazz == null) {
            throw new UnsupportedOperationException("Null class for persist.");
        }
        String jpql = "select e from " + clazz.getName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, clazz);
        
        if(quantity == -1) {
            query.setMaxResults(quantity);    
        }
        
        query.setFirstResult(offset);
        return query.getResultList();
    }

    @Override
    public T find(ID id) {
        return em.find(clazz, id);
    }
    
    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(ID id) {
        T entity = find(id);
        if(entity != null) {
            em.remove(entity);
        }
    }

    public DAO<T, ID> beginTrans() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<T, ID> commitTrans() {
        em.getTransaction().commit();
        return this;
    }

    public void close() {
        em.close();
    }

}
