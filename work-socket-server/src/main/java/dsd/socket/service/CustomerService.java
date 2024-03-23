package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Customer;
import dsd.socket.domain.Person;
import dsd.socket.protocol.Method;
import dsd.socket.request.RequestHandlerService;

import java.util.List;
import java.util.Optional;

public class CustomerService extends RequestHandlerService {
    
    private final DAO<Customer, String> dao;

    public CustomerService(DAO<Customer, String> dao) {
        this.dao = dao;
    }

    @Override
    protected void get(String request) {
        String cpf = extractIdFromRequest(request);

        List<Customer> customers = dao.findAll();

        if(customers.isEmpty()) {
            setResponse(new String("Sem clientes cadastrados."));
        }

        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();

        if(customer.isEmpty()) {
            setResponse(new String("Cliente não encontrado."));
            return;
        }

        setResponse(customer.toString());
    }

    @Override
    protected void list(String request) {
        List<Customer> customers = dao.findAll();

        if(customers.isEmpty()) {
            setResponse(0);
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(customers.size());
        customers.forEach(customer -> builder.append(customer.toString()));

        setResponse(builder.toString());
    }

    @Override
    protected void insert(String request) {
        String requestData[] = request.split(";");

        String cpf = extractIdFromRequest(request);
        String name = requestData[3];
        String address = requestData[4];
        String deliveryAddress = requestData[5];
        Double balanceDue = Double.valueOf(requestData[6]);
        String contact = requestData[7];

        Customer newCustomer = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact);
        try {
            dao.insert(newCustomer);
            setResponse(newCustomer);
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

    @Override
    protected void update(String request) {
        String requestData[] = request.split(";");

        String cpf = extractIdFromRequest(request);
        Customer customer = dao.find(cpf);

        if(customer == null) {
            setResponse(new String("Cliente não encontrado."));
            return;
        }

        customer.setName(requestData[3]);
        customer.setAddress(requestData[4]);
        customer.setDeliveryAddress(requestData[5]);
        customer.setBalanceDue(Double.valueOf(requestData[6]));
        customer.setContact(requestData[7]);

        try {
            dao.update(customer);
            setResponse(new String("Cliente atualizado com sucesso."));
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

    @Override
    protected void delete(String request) {
        String cpf = extractIdFromRequest(request);

        List<Customer> customers = dao.findAll();

        if(customers.isEmpty()) {
            setResponse(new String("Sem clientes cadastrados."));
        }

        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();

        if(customer.isEmpty()) {
            setResponse(new String("Cliente não encontrado."));
            return;
        }

        try {
            dao.delete(customer.get().getCpf());
            setResponse("Cliente removido com sucesso.");
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

}
