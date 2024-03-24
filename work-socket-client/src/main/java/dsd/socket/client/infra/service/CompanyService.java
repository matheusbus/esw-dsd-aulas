/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.service;

import dsd.socket.client.infra.request.CompanyRequest;
import dsd.socket.client.infra.request.method.CompanyMethod;
import dsd.socket.client.model.Company;
import dsd.socket.client.model.Customer;
import dsd.socket.client.model.Employee;
import dsd.socket.client.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matheus
 */
public class CompanyService implements Service<Company, Integer> {

    public CompanyService() {
    }

    @Override
    public Company insert(Company entity) {
        CompanyRequest request = new CompanyRequest();

        request.append("INSERT")
                .append(entity.getCnpj())
                .append(entity.getSocialReason())
                .append(String.valueOf(entity.getFoundedIn()))
                .send();

        String response = request.getResponse();
        String[] responseData = response.split(";");

        Integer id = Integer.valueOf(responseData[1]);
        String cnpj = responseData[2];
        String socialReason = responseData[3];

        Company newCompany = new Company(id, cnpj, socialReason, id, null);

        return newCompany;
    }

    @Override
    public Map<Integer, Company> findAll() {
        Map<Integer, Company> companies = new HashMap<>();
        CompanyRequest request = new CompanyRequest();

        request.append("LIST")
                .send();

        String response = request.getResponse();
        String[] companiesDataList = response.split("::");

        for (int i = 1; i < companiesDataList.length; i++) {
            String[] data = companiesDataList[i].split(";");

            Integer id = Integer.valueOf(data[0]);
            String cnpj = data[1];
            String socialReason = data[2];
            Integer foundedYear = Integer.valueOf(data[3]);

            List<Person> people = new ArrayList<>();
            if (!data[4].equals("[]")) {
                String[] peopleDataList = data[4].replace("[", "").replace("]", "").split("##");

                for (int j = 0; j < peopleDataList.length; j++) {
                    String[] peopleData = peopleDataList[j].split("%%");

                    if (peopleData[0].equals("Customer")) {
                        Customer c = new Customer();
                        c.setCpf(peopleData[1]);
                        c.setName(peopleData[2]);
                        c.setAddress(peopleData[3]);
                        c.setDeliveryAddress(peopleData[4]);
                        c.setBalanceDue(Double.valueOf(peopleData[5]));
                        c.setContact(peopleData[6]);

                        people.add(c);
                    } else if (peopleData[0].equals("Employee")) {
                        Employee e = new Employee();
                        e.setCpf(peopleData[1]);
                        e.setName(peopleData[2]);
                        e.setAddress(peopleData[3]);
                        e.setPosition(peopleData[4]);
                        e.setSalary(Double.valueOf(peopleData[5]));
                        e.setActive(Boolean.valueOf(peopleData[6]));

                        people.add(e);
                    }
                }
            }

            Company company = new Company(id, cnpj, socialReason, foundedYear, people);
            companies.put(company.getId(), company);
        }

        return companies;
    }

    @Override
    public Company update(Company entity) {
        CompanyRequest request = new CompanyRequest();

        request.append("UPDATE")
                .append(String.valueOf(entity.getId()))
                .append(entity.getCnpj())
                .append(entity.getSocialReason())
                .append(String.valueOf(entity.getFoundedIn()))
                .send();

        String response = request.getResponse();
        String[] responseData = response.split(";");

        Integer id = Integer.valueOf(responseData[1]);
        String cnpj = responseData[2];
        String socialReason = responseData[3];

        Company newCompany = new Company(id, cnpj, socialReason, id, null);
        return newCompany;
    }

    @Override
    public void delete(Integer id) {
        CompanyRequest request = new CompanyRequest();

        request.append(CompanyMethod.DELETE.toString())
                .append(String.valueOf(id))
                .send();
    }

    @Override
    public Company find(Integer id) {
        CompanyRequest request = new CompanyRequest();

        request.append(CompanyMethod.GET.toString())
                .append(String.valueOf(id))
                .send();

        String response = request.getResponse();

        if (response.equals("Empresa não encontrada.")) {
            return null;
        }

        if (response.equals("Sem empresas cadastradas.")) {
            return null;
        }

        String[] responseData = response.split(";");

        Integer idCompany = Integer.valueOf(responseData[0]);
        String cnpjCompany = responseData[1];
        String socialReasonCompany = responseData[2];
        Integer foundedIn = Integer.valueOf(responseData[3]);
        
        List<Person> people = new ArrayList<>();
        if (!responseData[4].equals("[]")) {
            String[] peopleDataList = responseData[4].replace("[", "").replace("]", "").split("##");

            for (int j = 0; j < peopleDataList.length; j++) {
                String[] peopleData = peopleDataList[j].split("%%");

                if (peopleData[0].equals("Customer")) {
                    Customer c = new Customer();
                    c.setCpf(peopleData[1]);
                    c.setName(peopleData[2]);
                    c.setAddress(peopleData[3]);
                    c.setDeliveryAddress(peopleData[4]);
                    c.setBalanceDue(Double.valueOf(peopleData[5]));
                    c.setContact(peopleData[6]);

                    people.add(c);
                } else if (peopleData[0].equals("Employee")) {
                    Employee e = new Employee();
                    e.setCpf(peopleData[1]);
                    e.setName(peopleData[2]);
                    e.setAddress(peopleData[3]);
                    e.setPosition(peopleData[4]);
                    e.setSalary(Double.valueOf(peopleData[5]));
                    e.setActive(Boolean.valueOf(peopleData[6]));

                    people.add(e);
                }
            }
        }

        Company company = new Company(idCompany, cnpjCompany, socialReasonCompany, foundedIn, people);
        return company;
    }

}
