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
    private final DAO<Company, Integer> companyDao;

    public EmployeeService(DAO<Employee, String> dao, DAO<Company, Integer> companyDao) {
        this.dao = dao;
        this.companyDao = companyDao;
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

        setResponse(employee.get().toString());
    }

    @Override
    protected void list(String request) {
        List<Employee> employees = dao.findAll();

        if(employees.isEmpty()) {
            setResponse(0);
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(employees.size() + "::");

        int lastIndex = employees.size() - 1;
        for (int i = 0; i < employees.size(); i++) {
            builder.append(employees.get(i).toString());
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
        String position = requestData[6];
        Double salary = Double.valueOf(requestData[7]);
        Boolean active = Boolean.valueOf(requestData[8]);

        if(company == null) {
            setResponse(new String("Empresa não encontrada."));
            return;
        }


        Employee newEmployee = new Employee(cpf, name, address, position, salary, active, company);
        try {
            dao.beginTrans();
            dao.insert(newEmployee);
            dao.commitTrans();
            setResponse(newEmployee);
        } catch (Exception ex) {
            dao.rollback();
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
            dao.beginTrans();
            dao.update(employee);
            dao.commitTrans();
            setResponse(employee);
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
