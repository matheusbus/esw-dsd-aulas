package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Customer;
import dsd.socket.protocol.CompanyMethod;
import dsd.socket.protocol.CustomerMethod;
import dsd.socket.request.RequestHandlerService;

public class CustomerService implements RequestHandlerService {
    
    private final DAO<Customer, String> dao;

    public CustomerService(DAO<Customer, String> dao) {
        this.dao = dao;
    }

    @Override
    public void handleRequest(String methodStr, String request) {
        CustomerMethod method = CustomerMethod.fromString(methodStr);

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
            case BUY:
                break;
        }
    }

    @Override
    public Object getResponse() {
        return null;
    }
}
