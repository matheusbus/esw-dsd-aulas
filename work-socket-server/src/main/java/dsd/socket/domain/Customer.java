package dsd.socket.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

import java.io.Serializable;

@Entity
@Table(name = "tbcustomer")
@Builder
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

    public Customer(String deliveryAddress, Double balanceDue, String contact, String cpf, String name, String address) {
        super(cpf, name, address);
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.balanceDue = balanceDue;
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
        return "Customer{" + "deliveryAddress=" + deliveryAddress + ", balanceDue=" + balanceDue + '}';
    }
        
}
