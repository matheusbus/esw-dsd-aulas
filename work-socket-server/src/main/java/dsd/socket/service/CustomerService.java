package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Customer;
import dsd.socket.domain.Person;
import dsd.socket.protocol.Method;
import dsd.socket.request.RequestHandlerService;

import java.util.List;

public class CustomerService extends RequestHandlerService {
    
    private final DAO<Customer, String> dao;

    private Object response;

    public CustomerService(DAO<Customer, String> dao) {
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

    public void createCustomer(String request) {
        String requestData[] = request.split(";");

        String cpf = requestData[1];
        String name = requestData[2];
        String address = requestData[3];
        String deliveryAddress = requestData[4];
        Double balanceDue = Double.valueOf(requestData[5]);
        String contact = requestData[6];

        Customer newCustomer = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact);
        dao.insert(newCustomer);
        setResponse(newCustomer);
    }

    @Override
    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
