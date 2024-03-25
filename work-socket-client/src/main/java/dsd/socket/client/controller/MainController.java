/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller;

import dsd.socket.client.controller.register.CompanyRegisterController;
import dsd.socket.client.controller.consult.CompanyPayrollController;
import dsd.socket.client.controller.consult.CompanyConsultController;
import dsd.socket.client.controller.base.BaseController;
import dsd.socket.client.controller.consult.CompanyReceivableController;
import dsd.socket.client.controller.consult.CustomerConsultController;
import dsd.socket.client.controller.consult.EmployeeConsultController;
import dsd.socket.client.controller.register.CustomerRegisterController;
import dsd.socket.client.controller.register.EmployeeRegisterController;
import dsd.socket.client.view.MainView;
import dsd.socket.client.view.consult.CompanyReceivableView;

/**
 *
 * @author Matheus
 */
public final class MainController implements BaseController {

    private final MainView view;

    public MainController() {
        this.view = new MainView();
        initButtons();
        showFrame();
    }
    
    @Override
    public void initButtons() {
        view.addActionBtnCompanyConsult((e) -> {
            actionBtnCompanyConsult();
        });
        view.addActionBtnCompanyRegister((e) -> {
            actionBtnCompanyRegister();
        });
        view.addActionBtnCompanyPayroll((e) -> {
            actionBtnCompanyPayroll();
        });
        view.addActionBtnCompanyReceivable((e) -> {
            actionBtnCompanyReceivable();
        });
        
        view.addActionBtnCustomerConsult((e) -> {
            actionBtnCustomerConsult();
        });
        view.addActionBtnCustomerRegister((e) -> {
            actionBtnCustomerRegister();
        });
        view.addActionBtnCustomerPayment((e) -> {
            actionBtnCustomerPayment();
        });
        
        view.addActionBtnEmployeeConsult((e) -> {
            actionBtnEmployeeConsult();
        });
        view.addActionBtnEmployeeRegister((e) -> {
            actionBtnEmployeeRegister();
        });
    }
    
    public void actionBtnCompanyConsult() {
        CompanyConsultController companyConsultController = new CompanyConsultController();
        companyConsultController.showFrame();
    }
    
    public void actionBtnCompanyRegister() {
        CompanyRegisterController companyRegisterController = new CompanyRegisterController();
        companyRegisterController.showFrame();
    }
    
    public void actionBtnCompanyPayroll() {
        CompanyPayrollController companyPayrollController = new CompanyPayrollController();
        companyPayrollController.showFrame();
    }
    
    public void actionBtnCompanyReceivable() {
        CompanyReceivableController companyReceivableController = new CompanyReceivableController();
        companyReceivableController.showFrame();
    }
    
    public void actionBtnCustomerConsult() {
        CustomerConsultController customerConsultController = new CustomerConsultController();
        customerConsultController.showFrame();
    }
    
    public void actionBtnCustomerRegister() {
        CustomerRegisterController customerRegisterController = new CustomerRegisterController();
        customerRegisterController.showFrame();
    }
    
    public void actionBtnCustomerPayment() {
        CustomerPaymentController customerPaymentController = new CustomerPaymentController();
        customerPaymentController.showFrame();
    }
    
    public void actionBtnEmployeeConsult() {
        EmployeeConsultController employeeConsultController = new EmployeeConsultController();
        employeeConsultController.showFrame();
    }
    
    public void actionBtnEmployeeRegister() {
        EmployeeRegisterController employeeRegisterController = new EmployeeRegisterController();
        employeeRegisterController.showFrame();
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
    
}
