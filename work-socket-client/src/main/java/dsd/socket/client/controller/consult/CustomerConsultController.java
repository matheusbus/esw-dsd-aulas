/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller.consult;

import dsd.socket.client.controller.register.CustomerRegisterController;
import dsd.socket.client.controller.base.BaseCosultController;
import dsd.socket.client.infra.service.CustomerService;
import dsd.socket.client.model.Customer;
import dsd.socket.client.view.consult.CustomerConsultView;
import dsd.socket.client.view.register.CustomerRegisterView;

/**
 *
 * @author Matheus
 */
public final class CustomerConsultController implements BaseCosultController {

    private final CustomerConsultView view;
    private final CustomerService customerService;

    public CustomerConsultController() {
        this.view = new CustomerConsultView();
        this.customerService = new CustomerService();
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
            view.fillTable(customerService.findAll());
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
                showMessage("No customer was found with the given identifier!", "Company not found");
            }
        } else {
            showMessage("Enter a valid identifier!", "Invalid identifier");
        }
        view.clearSearch();
    }

    public void actionRegister() {
        CustomerRegisterController customerRegisterController = new CustomerRegisterController();
        customerRegisterController.showFrame();
    }

    public void actionUpdate() {
        try {
            String cpf = view.getIdTableRecord();
            
            Customer customer = (Customer) customerService.find(cpf);
            CustomerRegisterController customerRegisterController = new CustomerRegisterController(new CustomerRegisterView(), customer, this);
            customerRegisterController.showFrame();
            fillTable();
        } catch (Exception e) {
            showMessage("No records were selected.", "Error");
        }
    }

    public void actionRemove() {
        try {
            if (0 == view.question("Are you sure you want to delete the selected record?", "Deletion confirmation")) {
                customerService.delete(view.getIdTableRecord());
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
