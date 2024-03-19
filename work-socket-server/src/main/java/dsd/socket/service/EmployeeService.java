package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Employee;
import dsd.socket.protocol.Method;
import dsd.socket.request.RequestHandlerService;

import java.util.List;

public class EmployeeService extends RequestHandlerService {
    
    private final DAO<Employee, String> dao;

    public EmployeeService(DAO<Employee, String> dao) {
        this.dao = dao;
    }


    @Override
    protected void get(String request) {
        return;
    }

    @Override
    protected void list(String request) {
        return;
    }

    @Override
    protected void insert(String request) {

    }

    @Override
    protected void update(String request) {
        return;
    }

    @Override
    protected void delete(String request) {

    }

    @Override
    public Object getResponse() {
        return null;
    }
}
