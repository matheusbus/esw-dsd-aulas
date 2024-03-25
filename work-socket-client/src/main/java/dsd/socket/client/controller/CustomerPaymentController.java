/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller;

import dsd.socket.client.controller.base.BaseController;
import dsd.socket.client.infra.service.CustomerService;
import dsd.socket.client.view.register.CustomerPaymentView;

/**
 *
 * @author Matheus
 */
public final class CustomerPaymentController implements BaseController {

    private CustomerPaymentView view;
    private CustomerService customerService =  new CustomerService();

    public CustomerPaymentController() {
        this.view = new CustomerPaymentView();
        initButtons();
    }

    @Override
    public void initButtons() {
        view.addActionBtnConnect(((e) -> {
            confirmPayment();
        }));
    }

    public void confirmPayment() {
        try {
            if (verifyFields()) {
                String cpf = view.getCpf();
                Double amount = Double.valueOf(view.getAmount());
                
                String response = customerService.makePayment(cpf, amount);
                
                showMessage(response, "Warning");
            } else {
                throw new Exception("Verify fields.");
            }

            closeFrame();
        } catch (Exception ex) {
            showMessage(ex.getMessage(), "Error");
        }
    }

    public boolean verifyFields() {
        return view.verifyFields();
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
