package dsd.socket.client.controller.consult;

import dsd.socket.client.controller.register.CustomerRegisterController;
import dsd.socket.client.controller.base.BaseCosultController;
import dsd.socket.client.controller.register.EmployeeRegisterController;
import dsd.socket.client.infra.service.EmployeeService;
import dsd.socket.client.model.Employee;
import dsd.socket.client.view.consult.EmployeeConsultView;
import dsd.socket.client.view.register.EmployeeRegisterView;

public final class EmployeeConsultController implements BaseCosultController {

    private final EmployeeConsultView view;
    private final EmployeeService employeeService;

    public EmployeeConsultController() {
        this.view = new EmployeeConsultView();
        this.employeeService = new EmployeeService();
        initButtons();
    }

    @Override
    public void initButtons() {
        view.addActionBtnRegister(((e) -> {
            actionRegister();
        }));
        view.addActionBtnSearch(((e) -> {
            actionSeacth();
        }));
        view.addActionBtnUpdate(((e) -> {
            actionUpdate();
        }));
        view.addActionBtnRemove(((e) -> {
            actionRemove();
        }));
        view.addActionBtnRefresh((e) -> {
            actionRefresh();
        });
    }

    @Override
    public void fillTable() {
        view.clearTable();
        
        try {
            view.fillTable(employeeService.findAll());
        } catch (Exception ex) {
            showMessage(ex.getMessage(), "Erro");
        }
        
    }
    
    public void actionRefresh() {
        fillTable();
    }

    public void actionSeacth() {
        view.clearSelection();
        String id = view.getFilter();
        if (!id.isEmpty()) {
            if (!view.searchTable(id)) {
                showMessage("No employee was found with the given identifier!", "Company not found");
            }
        } else {
            showMessage("Enter a valid identifier!", "Invalid identifier");
        }
        view.clearSearch();
    }

    public void actionRegister() {
        EmployeeRegisterController employeeRegisterController = new EmployeeRegisterController();
        employeeRegisterController.showFrame();
    }

    public void actionUpdate() {
        try {
            String cpf = view.getIdTableRecord();
            
            Employee employee = (Employee) employeeService.find(cpf);
            EmployeeRegisterController employeeRegisterController = new EmployeeRegisterController(new EmployeeRegisterView(), employee, this);
            employeeRegisterController.showFrame();
            fillTable();
        } catch (Exception e) {
            showMessage("No records were selected.", "Error");
        }
    }

    public void actionRemove() {
        try {
            if (0 == view.question("Are you sure you want to delete the selected record?", "Deletion confirmation")) {
                employeeService.delete(view.getIdTableRecord());
                fillTable();
                showMessage("Registration successfully removed", "Success");
            }
        } catch (Exception e) {
            showMessage("No records were selected.", "Error");
        }
    }

    public void clearTable() {
        view.clearTable();
    }

    @Override
    public void showFrame() {
        view.showFrame();
        fillTable();
    }

    @Override
    public void closeFrame() {
        view.closeFrame();
    }

    @Override
    public void showMessage(String message, String title) {
        view.showMessage(message, title);
    }

}
