/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.service;

import dsd.socket.client.infra.request.EmployeeRequest;
import dsd.socket.client.model.Company;
import dsd.socket.client.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matheus
 */
public class EmployeeService implements Service<Employee, String> {

    private final CompanyService companyService;

    public EmployeeService() {
        this.companyService = new CompanyService();
    }

    @Override
    public Employee insert(Employee entity) {
        EmployeeRequest request = new EmployeeRequest();

        request.append("INSERT")
                .append(entity.getCpf())
                .append(entity.getName())
                .append(entity.getAddress())
                .append(String.valueOf(entity.getCompany().getId()))
                .append(entity.getPosition())
                .append(String.valueOf(entity.getSalary()))
                .append(String.valueOf(entity.getActive()))
                .send();

        String response = request.getResponse();
        String[] responseData = response.split(";");

        String cpf = responseData[1];
        String name = responseData[2];
        String address = responseData[3];
        String position = responseData[5];
        Double salary = Double.valueOf(responseData[6]);
        Boolean active = Boolean.valueOf(responseData[7]);

        String[] companyData = responseData[4].replace("[", "").replace("]", "").split("##");
        Integer id = Integer.valueOf(companyData[0]);
        String cnpj = companyData[1];
        String socialReason = companyData[2];
        Integer foundedIn = Integer.valueOf(companyData[3]);

        Company company = new Company(id, cnpj, socialReason, foundedIn, new ArrayList<>());
        Employee employee = new Employee(cpf, name, address, position, salary, active, company);
        company.addPerson(employee);

        return employee;
    }

    @Override
    public Map<String, Employee> findAll() {
        Map<String, Employee> employees = new HashMap<>();
        EmployeeRequest request = new EmployeeRequest();

        request.append("LIST")
                .send();

        String response = request.getResponse();
        String[] employeesDataList = response.split("::");

        for (int i = 1; i < employeesDataList.length; i++) {
            String[] data = employeesDataList[i].split(";");

            String cpf = data[1];
            String name = data[2];
            String address = data[3];
            String position = data[5];
            Double salary = Double.valueOf(data[6]);
            Boolean active = Boolean.valueOf(data[7]);

            Company company = null;
            if (!data[4].equals("[]")) {
                String[] companyData = data[4].replace("[", "").replace("]", "").split("##");
                Integer id = Integer.valueOf(companyData[0]);
                String cnpj = companyData[1];
                String socialReason = companyData[2];
                Integer foundedIn = Integer.valueOf(companyData[3]);

                company = new Company(id, cnpj, socialReason, foundedIn, new ArrayList<>());
            }

            Employee e = new Employee(cpf, name, address, position, salary, active, company);
            if (company != null) {
                company.addPerson(e);
            }
            employees.put(e.getCpf(), e);
        }

        return employees;
    }

    @Override
    public Employee update(Employee entity) {
        EmployeeRequest request = new EmployeeRequest();

        request.append("UPDATE")
                .append(entity.getCpf())
                .append(entity.getName())
                .append(entity.getAddress())
                .append(entity.getPosition())
                .append(String.valueOf(entity.getSalary()))
                .append(String.valueOf(entity.getActive()))
                .send();

        String response = request.getResponse();
        String[] responseData = response.split(";");
        
        String cpf = responseData[1];
        String name = responseData[2];
        String address = responseData[3];
        String position = responseData[5];
        Double salary = Double.valueOf(responseData[6]);
        Boolean active = Boolean.valueOf(responseData[7]);

        String[] companyData = responseData[4].replace("[", "").replace("]", "").split("##");
        Integer id = Integer.valueOf(companyData[0]);
        String cnpj = companyData[1];
        String socialReason = companyData[2];
        Integer foundedIn = Integer.valueOf(companyData[3]);

        Company company = new Company(id, cnpj, socialReason, foundedIn, new ArrayList<>());
        Employee employee = new Employee(cpf, name, address, position, salary, active, company);
        company.addPerson(employee);

        return employee;
    }

    @Override
    public void delete(String id) {
        EmployeeRequest request = new EmployeeRequest();

        request.append("DELETE")
                .append(String.valueOf(id))
                .send();
    }

    @Override
    public Employee find(String id) {
        EmployeeRequest request = new EmployeeRequest();

        request.append("GET")
                .append(String.valueOf(id))
                .send();

        String response = request.getResponse();

        if (response.equals("Funcionário não encontrado.")) {
            return null;
        }

        if (response.equals("Sem funcionários cadastrados.")) {
            return null;
        }

        String[] responseData = response.split(";");

        String cpf = responseData[1];
        String name = responseData[2];
        String address = responseData[3];
        String position = responseData[5];
        Double salary = Double.valueOf(responseData[6]);
        Boolean active = Boolean.valueOf(responseData[7]);

        String[] companyData = responseData[4].replace("[", "").replace("]", "").split("##");
        Integer idCompany = Integer.valueOf(companyData[0]);
        String cnpj = companyData[1];
        String socialReason = companyData[2];
        Integer foundedIn = Integer.valueOf(companyData[3]);

        Company company = new Company(idCompany, cnpj, socialReason, foundedIn, new ArrayList<>());
        Employee employee = new Employee(cpf, name, address, position, salary, active, company);
        company.addPerson(employee);

        return employee;
    }

}
