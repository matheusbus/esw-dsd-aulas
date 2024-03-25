package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.domain.Customer;
import dsd.socket.protocol.CustomerMethod;
import dsd.socket.request.RequestHandlerService;

import java.util.List;
import java.util.Optional;

public class CustomerService extends RequestHandlerService {

    private final DAO<Customer, String> dao;
    private final DAO<Company, Integer> companyDao;

    public CustomerService(DAO<Customer, String> dao, DAO<Company, Integer> companyDao) {
        this.dao = dao;
        this.companyDao = companyDao;
    }

    @Override
    protected void handleRequest(String methodStr, String request) {
        CustomerMethod method = CustomerMethod.fromString(methodStr);

        switch (method) {
            case GET:
                get(request);
                break;
            case LIST:
                list(request);
                break;
            case INSERT:
                insert(request);
                break;
            case UPDATE:
                update(request);
                break;
            case DELETE:
                delete(request);
                break;
            case PAY:
                makePayment(request);
                break;
        }
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

        setResponse(customer.get().toString());
    }

    @Override
    protected void list(String request) {
        List<Customer> customers = dao.findAll();

        if(customers.isEmpty()) {
            setResponse(0);
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(customers.size() + "::");

        int lastIndex = customers.size() - 1;
        for (int i = 0; i < customers.size(); i++) {
            builder.append(customers.get(i).toString());
            if (i != lastIndex) {
                builder.append("::");
            }
        }

        setResponse(builder.toString());
    }

    @Override
    protected void insert(String request) {
        String requestData[] = request.split(";");

        String cpf = extractIdFromRequest(request);
        String name = requestData[3];
        String address = requestData[4];
        Integer companyId = Integer.parseInt(requestData[5]);
        Company company = companyDao.find(companyId);
        String deliveryAddress = requestData[6];
        Double balanceDue = Double.valueOf(requestData[7]);
        String contact = requestData[8];


        if(company == null) {
            setResponse(new String("Empresa não encontrada."));
            return;
        }

        Customer newCustomer = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact, company);
        try {
            dao.beginTrans();
            dao.insert(newCustomer);
            dao.commitTrans();
            setResponse(newCustomer);
        } catch (Exception ex) {
            dao.rollback();
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
            setResponse(customer);
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

    public void makePayment(String request) {
        String cpf = extractIdFromRequest(request);

        List<Customer> customers = dao.findAll();

        if(customers.isEmpty()) {
            setResponse(new String("Sem clientes cadastrados."));
        }

        Optional<Customer> customerOptional = customers.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();

        if(customerOptional.isEmpty()) {
            setResponse(new String("Cliente não encontrado."));
            return;
        }

        Customer customer = customerOptional.get();

        try {
            Double amount = Double.valueOf(request.split(";")[3]);
            customer.makePayment(amount);

            dao.beginTrans();
            dao.update(customer);
            dao.commitTrans();

            setResponse("Pagamento realizado com sucesso. Novo saldo devedor: R$" + customer.getBalanceDue());
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

}
