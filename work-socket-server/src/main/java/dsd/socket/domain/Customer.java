package dsd.socket.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.sql.exec.ExecutionException;

import java.io.Serializable;

@Entity
@Table(name = "tbcustomer")
public class Customer extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cst_deliveryaddress")
    private String deliveryAddress;

    @Column(name = "cst_balanceDue")
    private Double balanceDue;

    @Column(name = "cst_contact")
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

    public void makePayment(Double amount) throws Exception {
        if(amount > this.balanceDue) {
            throw new Exception("Montante maior que saldo devedor. Saldo devedor: R$" + this.balanceDue);
        }
        this.balanceDue -= amount;
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
            .append(this.getContact())
            .toString();
    }

    @Override
    public String toStringWithNoCompany() {

        return new StringBuilder()
                .append(this.getClass().getSimpleName() + ";")
                .append(this.getCpf() + ";")
                .append(this.getName() + ";")
                .append(this.getAddress() + ";")
                .append(this.getDeliveryAddress() + ";")
                .append(this.getBalanceDue() + ";")
                .append(this.getContact())
                .toString();
    }
}
