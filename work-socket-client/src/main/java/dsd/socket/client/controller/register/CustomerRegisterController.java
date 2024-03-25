/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller.register;

import dsd.socket.client.controller.base.BaseRegisterController;
import dsd.socket.client.controller.consult.CustomerConsultController;
import dsd.socket.client.infra.service.CompanyService;
import dsd.socket.client.infra.service.CustomerService;
import dsd.socket.client.model.Company;
import dsd.socket.client.model.Customer;
import dsd.socket.client.view.register.CustomerRegisterView;

/**
 *
 * @author Matheus
 */
public final class CustomerRegisterController implements BaseRegisterController {

    private CustomerRegisterView view;
    private Customer customer;
    private CustomerConsultController customerConsultController;
    private CustomerService customerService = new CustomerService();
    private CompanyService companyService = new CompanyService();

    public CustomerRegisterController() {
        this.view = new CustomerRegisterView();
        this.customer = null;
        initButtons();
        initializeRegister();
    }

    public CustomerRegisterController(CustomerRegisterView view, Customer customer, CustomerConsultController customerConsultController) {
        this.view = view;
        this.customer = customer;
        this.customerConsultController = customerConsultController;
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
            view.setCpf(customer.getCpf());
            view.setName(customer.getName());
            view.setAddress(customer.getAddress());
            view.setDeliveryAddress(customer.getDeliveryAddress());
            view.setBalanceDue(String.valueOf(customer.getBalanceDue()));
            view.setContact(customer.getContact());
            view.setId(String.valueOf(customer.getCompany().getId()));
            view.setCnpj(customer.getCompany().getCnpj());
            view.setSocialReason(customer.getCompany().getSocialReason());
            view.setFoundedYear(String.valueOf(customer.getCompany().getFoundedIn()));
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
                String deliveryAddress = view.getDeliveryAddress();
                Double balanceDue = Double.valueOf(view.getBalanceDue());
                String contact = view.getContact();
                
                if(view.getId().isBlank()) {
                    throw new Exception("Company id is null.");
                }
                
                Company company = companyService.find(Integer.valueOf(view.getId()));
                
                Customer c = new Customer(cpf, name, address, deliveryAddress, balanceDue, contact, company);
                customerService.insert(c);

                showMessage("Registered successfully!", "Error");
                if (customerConsultController != null) {
                    customerConsultController.fillTable();
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
                String deliveryAddress = view.getDeliveryAddress();
                Double balanceDue = Double.valueOf(view.getBalanceDue());
                String contact = view.getContact();
                
                if(view.getId().isBlank()) {
                    throw new Exception("Company id is null.");
                }
                
                customer.setCpf(cpf);
                customer.setName(name);
                customer.setAddress(address);
                customer.setDeliveryAddress(deliveryAddress);
                customer.setBalanceDue(balanceDue);
                customer.setContact(contact);
                
                Integer idCompany = Integer.valueOf(view.getId());
                Company newComapny = companyService.find(idCompany);
                
                customer.setCompany(newComapny);

                customerService.update(customer);

                showMessage("Updated successfully!", "Success");
                closeFrame();
                customerConsultController.fillTable();

            } catch (Exception ex) {
                showMessage(ex.getMessage(), "Error");
            }
        } else {
            showMessage("Check the fields", "Error");
        }
    }

}
