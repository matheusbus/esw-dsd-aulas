package dsd.socket.dao;

import java.util.List;

public interface DAO<T, ID> {

    T insert(T entity);
    List<T> findAll();
    T update(T entity);
    void delete(ID id);
    T find(ID id);

    DAO<T, ID>  beginTrans();
    DAO<T, ID>  commitTrans();
    DAO<T, ID>  rollback();

}