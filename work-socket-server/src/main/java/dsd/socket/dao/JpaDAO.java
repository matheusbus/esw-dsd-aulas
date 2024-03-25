package dsd.socket.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

        if(quantity != -1) {
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
        em.merge(entity);
        return entity;
    }

    @Override
    public void delete(ID id) {
        try {
            beginTrans(); // Iniciar transação
            T entity = find(id);
            if(entity != null) {
                em.remove(entity);
                commitTrans(); // Confirmar transação se a exclusão for bem-sucedida
            } else {
                rollback(); // Fazer rollback se a entidade não for encontrada
            }
        } catch (Exception ex) {
            rollback(); // Fazer rollback em caso de exceção
            throw new RuntimeException("Erro ao excluir a entidade", ex); // Lidar com exceção
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

    public DAO<T, ID> rollback() {
        em.getTransaction().rollback();
        return this;
    }

    public void close() {
        em.close();
    }

}
