/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.service;

import dsd.socket.client.infra.request.CustomerRequest;
import dsd.socket.client.model.Company;
import dsd.socket.client.model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matheus
 */
public class CustomerService implements Service<Customer, String> {

    private final CompanyService companyService;

    public CustomerService() {
        this.companyService = new CompanyService();
    }

    @Override
    public Customer insert(Customer entity) {
        CustomerRequest request = new CustomerRequest();

        request.append("INSERT")
                .append(entity.getCpf())
                .append(entity.getName())
                .append(entity.getAddress())
                .append(String.valueOf(entity.getCompany().getId()))
                .append(entity.getDeliveryAddress())
                .append(String.valueOf(entity.getBalanceDue()))
                .append(entity.getContact())
                .send();

        String response = request.getResponse();
        String[] responseData = response.split(";");

        String cpf = responseData[1];
        String name = responseData[2];
        String address = responseData[3];
        String deliveryAddress = responseData[5];
        Double balanceDue = Double.valueOf(responseData[6]);
        String contact = responseData[7];

        String[] companyData = responseData[4].replace("[", "").replace("]", "").split("##");
        Integer id = Integer.valueOf(companyData[0]);
        String cnpj = companyData[1];
        String socialReason = companyData[2];
        Integer foundedIn = Integer.valueOf(companyData[3]);

        Company company = new Company(id, cnpj, socialReason, foundedIn, new ArrayList<>());
        Customer customer = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact, company);
        company.addPerson(customer);

        return customer;
    }

    @Override
    public Map<String, Customer> findAll() {
        Map<String, Customer> customers = new HashMap<>();
        CustomerRequest request = new CustomerRequest();

        request.append("LIST")
                .send();

        String response = request.getResponse();
        String[] customersDataList = response.split("::");

        for (int i = 1; i < customersDataList.length; i++) {
            String[] data = customersDataList[i].split(";");

            String cpf = data[1];
            String name = data[2];
            String address = data[3];
            String deliveryAddress = data[5];
            Double balanceDue = Double.valueOf(data[6]);
            String contact = data[7];

            Company company = null;
            if (!data[4].equals("[]")) {
                String[] companyData = data[4].replace("[", "").replace("]", "").split("##");
                Integer id = Integer.valueOf(companyData[0]);
                String cnpj = companyData[1];
                String socialReason = companyData[2];
                Integer foundedIn = Integer.valueOf(companyData[3]);

                company = new Company(id, cnpj, socialReason, foundedIn, new ArrayList<>());
            }

            Customer c = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact, company);
            if (company != null) {
                company.addPerson(c);
            }
            customers.put(c.getCpf(), c);
        }

        return customers;
    }

    @Override
    public Customer update(Customer entity) {
        CustomerRequest request = new CustomerRequest();

        request.append("UPDATE")
                .append(entity.getCpf())
                .append(entity.getName())
                .append(entity.getAddress())
                .append(entity.getDeliveryAddress())
                .append(String.valueOf(entity.getBalanceDue()))
                .append(entity.getContact())
                .send();

        String response = request.getResponse();
        String[] responseData = response.split(";");

        String cpf = responseData[1];
        String name = responseData[2];
        String address = responseData[3];
        String deliveryAddress = responseData[5];
        Double balanceDue = Double.valueOf(responseData[6]);
        String contact = responseData[7];

        String[] companyData = responseData[4].replace("[", "").replace("]", "").split("##");
        Integer id = Integer.valueOf(companyData[0]);
        String cnpj = companyData[1];
        String socialReason = companyData[2];
        Integer foundedIn = Integer.valueOf(companyData[3]);

        Company company = new Company(id, cnpj, socialReason, foundedIn, new ArrayList<>());
        Customer customer = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact, company);
        company.addPerson(customer);

        return customer;
    }

    @Override
    public void delete(String id) {
        CustomerRequest request = new CustomerRequest();

        request.append("DELETE")
                .append(String.valueOf(id))
                .send();
    }

    @Override
    public Customer find(String id) {
        CustomerRequest request = new CustomerRequest();

        request.append("GET")
                .append(String.valueOf(id))
                .send();

        String response = request.getResponse();

        if (response.equals("Cliente não encontrado.")) {
            return null;
        }

        if (response.equals("Sem clientes cadastrados.")) {
            return null;
        }

        String[] responseData = response.split(";");

        String cpf = responseData[1];
        String name = responseData[2];
        String address = responseData[3];
        String deliveryAddress = responseData[5];
        Double balanceDue = Double.valueOf(responseData[6]);
        String contact = responseData[7];

        String[] companyData = responseData[4].replace("[", "").replace("]", "").split("##");
        Integer idCompany = Integer.valueOf(companyData[0]);
        String cnpj = companyData[1];
        String socialReason = companyData[2];
        Integer foundedIn = Integer.valueOf(companyData[2]);

        Company company = new Company(idCompany, cnpj, socialReason, foundedIn, null);
        Customer customer = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact, company);
        company.addPerson(customer);

        return customer;
    }

}
