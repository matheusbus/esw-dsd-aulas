package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Employee;
import dsd.socket.protocol.EmployeeMethod;
import dsd.socket.request.RequestHandlerService;

public class EmployeeService implements RequestHandlerService {
    
    private final DAO<Employee, String> dao;

    public EmployeeService(DAO<Employee, String> dao) {
        this.dao = dao;
    }

    @Override
    public void handleRequest(String methodStr, String request) {
        EmployeeMethod method = EmployeeMethod.fromString(methodStr);

        // VAI CHAMAR OS MÉTODOS PARA CADA TIPO DE MÉTODO
        switch (method) {
            case GET:
                break;
            case LIST:
                break;
            case INSERT:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            case RESIGN:
                break;
        }
    }

    @Override
    public Object getResponse() {
        return null;
    }
}
