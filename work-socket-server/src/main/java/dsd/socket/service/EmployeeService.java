package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.domain.Employee;
import dsd.socket.protocol.EmployeeMethod;
import dsd.socket.request.RequestHandlerService;

import java.util.List;
import java.util.Optional;

public class EmployeeService extends RequestHandlerService {
    
    private final DAO<Employee, String> dao;

    private final CompanyService companyService;

    public EmployeeService(DAO<Employee, String> dao, DAO<Company, Integer> companyDao) {
        this.dao = dao;
        this.companyService = new CompanyService(companyDao);
    }

    @Override
    protected void handleRequest(String methodStr, String request) {
        EmployeeMethod method = EmployeeMethod.fromString(methodStr);

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
        }
    }

    @Override
    protected void get(String request) {
        String cpf = extractIdFromRequest(request);

        List<Employee> employees = dao.findAll();

        if(employees.isEmpty()) {
            setResponse(new String("Sem funcionários cadastrados."));
        }

        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getCpf().equals(cpf))
                .findFirst();

        if(employee.isEmpty()) {
            setResponse(new String("Funcionário não encontrado."));
            return;
        }

        setResponse(employee.toString());
    }

    @Override
    protected void list(String request) {
        List<Employee> employees = dao.findAll();

        if(employees.isEmpty()) {
            setResponse(0);
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(employees.size());
        employees.forEach(employee -> builder.append(employee.toString() + ","));

        setResponse(builder.toString());
    }

    @Override
    protected void insert(String request) {
        String requestData[] = request.split(";");

        String cpf = extractIdFromRequest(request);
        String name = requestData[3];
        String address = requestData[4];
        String position = requestData[5];
        Double salary = Double.valueOf(requestData[6]);
        Boolean active = Boolean.valueOf(requestData[7]);

        Employee newEmployee = new Employee(cpf, name, address, position, salary, active);
        try {
            dao.insert(newEmployee);
            setResponse(newEmployee);
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

    @Override
    protected void update(String request) {
        String requestData[] = request.split(";");

        String cpf = extractIdFromRequest(request);
        Employee employee = dao.find(cpf);

        if(employee == null) {
            setResponse(new String("Funcionário não encontrado."));
            return;
        }

        employee.setName(requestData[3]);
        employee.setAddress(requestData[4]);
        employee.setPosition(requestData[5]);
        employee.setSalary(Double.valueOf(requestData[6]));
        employee.setActive(Boolean.valueOf(requestData[7]));

        try {
            dao.update(employee);
            setResponse(new String("Funcionário atualizado com sucesso."));
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

    @Override
    protected void delete(String request) {
        String cpf = extractIdFromRequest(request);

        List<Employee> employees = dao.findAll();

        if(employees.isEmpty()) {
            setResponse(new String("Sem funcionários cadastrados."));
        }

        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getCpf().equals(cpf))
                .findFirst();

        if(employee.isEmpty()) {
            setResponse(new String("Funcionário não encontrado."));
            return;
        }

        try {
            dao.delete(employee.get().getCpf());
            setResponse("Funcionário removido com sucesso.");
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }

}
