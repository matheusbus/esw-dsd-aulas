package dsd.socket.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author matheus.buschermoehl
 */
@Entity
@Table(name = "tbcustomer")
public class Customer extends Person {
    
    @Column(name = "cst_deliveryaddress")
    private String deliveryAddress;
    
    @Column(name = "cst_type")
    private Character customerType;

    public Customer() {
    }

    public Customer(String deliveryAddress, Character customerType, String cpf, String name, String address) {
        super(cpf, name, address);
        this.deliveryAddress = deliveryAddress;
        this.customerType = customerType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Character getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Character customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" + "deliveryAddress=" + deliveryAddress + ", customerType=" + customerType + '}';
    }
        
}
