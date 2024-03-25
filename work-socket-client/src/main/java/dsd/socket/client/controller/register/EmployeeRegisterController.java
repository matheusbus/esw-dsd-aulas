/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller.register;

import dsd.socket.client.controller.base.BaseRegisterController;
import dsd.socket.client.controller.consult.EmployeeConsultController;
import dsd.socket.client.infra.service.CompanyService;
import dsd.socket.client.infra.service.EmployeeService;
import dsd.socket.client.model.Company;
import dsd.socket.client.model.Employee;
import dsd.socket.client.view.register.EmployeeRegisterView;

/**
 *
 * @author Matheus
 */
public final class EmployeeRegisterController implements BaseRegisterController {

    private EmployeeRegisterView view;
    private Employee employee;
    private EmployeeConsultController employeeConsultController;
    private EmployeeService employeeService = new EmployeeService();
    private CompanyService companyService = new CompanyService();

    public EmployeeRegisterController() {
        this.view = new EmployeeRegisterView();
        this.employee = null;
        initButtons();
        initializeRegister();
    }

    public EmployeeRegisterController(EmployeeRegisterView view, Employee employee, EmployeeConsultController employeeConsultController) {
        this.view = view;
        this.employee = employee;
        this.employeeConsultController = employeeConsultController;
        initButtons();
        initializeUpdate();
        populateFields();
    }

    @Override
    public void initButtons() {
        view.addActionBtnRegister((e) -> {
            actionRegister();
        });
        view.addActionBtnUpdate((e) -> {
            actionUpdate();
        });
        view.addActionBtnCancel((e) -> {
            actionCancel();
        });
    }

    @Override
    public void showFrame() {
        view.showFrame();
    }

    @Override
    public void closeFrame() {
        view.closeFrame();
    }

    @Override
    public void showMessage(String message, String title) {
        view.showMessage(message, title);
    }

    @Override
    public boolean verifyNullFields() {
        return view.verifyNullFields();
    }

    public void initializeRegister() {
        view.initializeRegister();
    }

    public void initializeUpdate() {
        view.initializeUpdate();
    }

    public void actionCancel() {
        closeFrame();
    }

    public void populateFields() {
        try {
            view.setCpf(employee.getCpf());
            view.setName(employee.getName());
            view.setAddress(employee.getAddress());
            view.setPosition(employee.getPosition());
            view.setSalary(String.valueOf(employee.getSalary()));
            view.setActive(employee.getActive());
            view.setId(String.valueOf(employee.getCompany().getId()));
            view.setCnpj(employee.getCompany().getCnpj());
            view.setSocialReason(employee.getCompany().getSocialReason());
            view.setFoundedYear(String.valueOf(employee.getCompany().getFoundedIn()));
        } catch (Exception ex) {
            showMessage("Error when filling in fields: " + ex.getMessage(), "Error");
        }
    }

    public void actionRegister() {
        if (verifyNullFields()) {
            try {
                String cpf = view.getCpf();
                String name = view.getName();
                String address = view.getAddress();
                String position = view.getPosition();
                Double salary = Double.valueOf(view.getSalary());
                Boolean active = view.getActive();
                
                if(view.getId().isBlank()) {
                    throw new Exception("Company id is null.");
                }
                
                Company company = companyService.find(Integer.valueOf(view.getId()));
                
                Employee e = new Employee(cpf, name, address, position, salary, active, company);
                employeeService.insert(e);

                showMessage("Registered successfully!", "Error");
                if (employeeConsultController != null) {
                    employeeConsultController.fillTable();
                }
                closeFrame();

            } catch (Exception ex) {
                showMessage(ex.getMessage(), "Error");
            }
        } else {
            showMessage("Check the fields", "Error");
        }
    }

    public void actionUpdate() {
        if (verifyNullFields()) {
            try {
                String cpf = view.getCpf();
                String name = view.getName();
                String address = view.getAddress();
                String position = view.getPosition();
                Double salary = Double.valueOf(view.getSalary());
                Boolean active = view.getActive();
                
                employee.setCpf(cpf);
                employee.setName(name);
                employee.setAddress(address);
                employee.setPosition(position);
                employee.setSalary(salary);
                employee.setActive(active);
                
                Integer idCompany = Integer.valueOf(view.getId());
                Company newComapny = companyService.find(idCompany);
                
                employee.setCompany(newComapny);

                employeeService.update(employee);

                showMessage("Updated successfully!", "Success");
                closeFrame();
                employeeConsultController.fillTable();

            } catch (Exception ex) {
                showMessage(ex.getMessage(), "Error");
            }
        } else {
            showMessage("Check the fields", "Error");
        }
    }

}
