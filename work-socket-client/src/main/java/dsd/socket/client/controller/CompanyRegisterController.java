/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller;

import dsd.socket.client.controller.base.BaseRegisterController;
import dsd.socket.client.model.Company;
import dsd.socket.client.view.register.CompanyRegisterView;

/**
 *
 * @author Matheus
 */
public final class CompanyRegisterController implements BaseRegisterController {

    private CompanyRegisterView view;
    private Company company;
    private CompanyRegisterController companyRegisterController;

    public CompanyRegisterController() {
        this.view = new CompanyRegisterView();
        this.company = null;
        initButtons();
        initializeRegister();
    }

    public CompanyRegisterController(CompanyRegisterView view, Company company, CompanyRegisterController companyRegisterController) {
        this.view = view;
        this.company = company;
        this.companyRegisterController = companyRegisterController;
        initButtons();
        initializeRegister();
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
            view.setId(String.valueOf(company.getId()));
            view.setCnpj(company.getCnpj());
            view.setSocialReason(company.getSocialReason());
            view.setFoundedYear(String.valueOf(company.getFoundedIn()));
        } catch (Exception ex) {
            showMessage("Error when filling in fields: " + ex.getMessage(), "Error");
        }
    }
    
    public void actionRegister() {
        if(verifyNullFields()) {
            try {
                Integer id = Integer.valueOf(view.getId());
                String cnpj = view.getCnpj();
                String socialReason = view.getSocialReason();
                Integer foundedYear = Integer.valueOf(view.getFoundedYear());
                
                // enviar requisição para insert
                
            } catch (Exception ex) {
                showMessage(ex.getMessage(), "Error");
            }
        } else {
            showMessage("Check the fields", "Error");
        }
    }

    public void actionUpdate() {
        if(verifyNullFields()) {
            try {
                Integer id = Integer.valueOf(view.getId());
                String cnpj = view.getCnpj();
                String socialReason = view.getSocialReason();
                Integer foundedYear = Integer.valueOf(view.getFoundedYear());
                
                company.setCnpj(cnpj);
                company.setSocialReason(socialReason);
                company.setFoundedIn(foundedYear);
                
                // enviar requisição para update
                
                showMessage("Updated successfully!", "Success");
                
            } catch (Exception ex) {
                showMessage(ex.getMessage(), "Error");
            }
        } else {
            showMessage("Check the fields", "Error");
        }
    }
    
}
