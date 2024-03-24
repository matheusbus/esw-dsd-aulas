/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller;

import dsd.socket.client.controller.base.BaseCosultController;
import dsd.socket.client.infra.service.CompanyService;
import dsd.socket.client.model.Company;
import dsd.socket.client.view.consult.CompanyConsultView;
import dsd.socket.client.view.register.CompanyRegisterView;

/**
 *
 * @author Matheus
 */
public final class CompanyConsultController implements BaseCosultController {

    private final CompanyConsultView view;
    private final Company companySelected;
    private final CompanyService companyService;

    public CompanyConsultController() {
        this.view = new CompanyConsultView();
        this.companySelected = null;
        this.companyService = new CompanyService();
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
    }

    @Override
    public void fillTable() {
        view.clearTable();
        
        try {
            view.fillTable(companyService.findAll());
        } catch (Exception ex) {
            showMessage(ex.getMessage(), "Erro");
        }
        
    }

    public void actionSeacth() {
        view.clearSelection();
        String id = view.getFilter();
        if (!id.isEmpty()) {
            if (view.searchTable(id)) {
                showMessage("Success!", "Success");
            } else {
                showMessage("No company was found with the given identifier!", "Company not found");
            }
        } else {
            showMessage("Enter a valid identifier!", "Invalid identifier");
        }
    }

    public void actionRegister() {
        CompanyRegisterController companyRegisterController = new CompanyRegisterController();
        companyRegisterController.showFrame();
    }

    public void actionUpdate() {
        try {
            String id = view.getIdTableRecord();
            
            Company company = (Company) companyService.find(Integer.valueOf(id));
            CompanyRegisterController companyRegisterController = new CompanyRegisterController(new CompanyRegisterView(), company, this);
            companyRegisterController.showFrame();
        } catch (Exception e) {
            showMessage("No records were selected.", "Error");
        }
    }

    public void actionRemove() {
        try {
            if (0 == view.question("Are you sure you want to delete the selected record?", "Deletion confirmation")) {
                companyService.delete(Integer.valueOf(view.getIdTableRecord()));
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
