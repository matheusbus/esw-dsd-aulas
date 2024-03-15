package dsd.socket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InMemoryDAO<T, ID> implements DAO<T, ID>{

    private Map<ID, T> data = new HashMap<>();

    @Override
    public List<T> findAll(){
        List<Map.Entry<ID, T>> list = new ArrayList<>(data.entrySet());
        return (List<T>) list;
    }

    @Override
    public void delete(ID id) {
        data.remove(id);
    }

    @Override
    public T find(ID id) {
        if(data.containsKey(id)) {
            return data.get(id);
        }
        return null;
    }

}
