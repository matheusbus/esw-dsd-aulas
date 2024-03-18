package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Customer;
import dsd.socket.domain.Person;
import dsd.socket.protocol.Method;
import dsd.socket.request.RequestHandlerService;

public class CustomerService implements RequestHandlerService {
    
    private final DAO<Customer, String> dao;

    private Object response;

    public CustomerService(DAO<Customer, String> dao) {
        this.dao = dao;
    }

    @Override
    public void handleRequest(String methodStr, String request) {
        Method method = Method.fromString(methodStr);

        // VAI CHAMAR OS MÉTODOS PARA CADA TIPO DE MÉTODO
        switch (method) {
            case GET:
                break;
            case LIST:
                break;
            case INSERT:
                createCustomer(request);
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
        }
    }

    public void createCustomer(String request) {
        String requestData[] = request.split(";");

        String cpf = requestData[1];
        String name = requestData[2];
        String address = requestData[3];
        String deliveryAddress = requestData[4];
        Double balanceDue = Double.valueOf(requestData[5]);
        String contact = requestData[6];

        Customer newCustomer = new Customer(deliveryAddress, balanceDue, contact, cpf, name, address);
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
