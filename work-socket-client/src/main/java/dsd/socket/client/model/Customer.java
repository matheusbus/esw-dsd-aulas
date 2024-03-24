/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.model;

/**
 *
 * @author Matheus
 */
public class Customer extends Person {
    
    private String deliveryAddress;
    private Double balanceDue;
    private String contact;

    public Customer() {
    }

    public Customer(String cpf, String name, String address, String deliveryAddress, Double balanceDue, String contact, Company company) {
        super(cpf, name, address);
        this.deliveryAddress = deliveryAddress;
        this.balanceDue = balanceDue;
        this.contact = contact;
        this.company = company;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Double getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(Double balanceDue) {
        this.balanceDue = balanceDue;
    }

    @Override
    public String toString() {
        StringBuilder companyString = new StringBuilder();

        if(company == null) {
            companyString.append("[]");
        } else {
            companyString = new StringBuilder()
                .append("[")
                .append(company.getId()).append(";")
                .append(company.getCnpj()).append(";")
                .append(company.getSocialReason()).append(";")
                .append(company.getFoundedIn())
                .append("]");
        }


        return new StringBuilder()
            .append(this.getClass().getSimpleName() + ";")
            .append(this.getCpf() + ";")
            .append(this.getName() + ";")
            .append(this.getAddress() + ";")
            .append(companyString + ";")
            .append(this.getDeliveryAddress() + ";")
            .append(this.getBalanceDue() + ";")
            .append(this.getContact() + ";")
            .toString();
    }
    
}
