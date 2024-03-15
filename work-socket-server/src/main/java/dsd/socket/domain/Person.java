package dsd.socket.domain;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author matheus.buschermoehl
 */
@Entity
@Table(name = "tbperson")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "per_cpf")
    private String cpf;
    
    @Column(name = "per_name", nullable = false)
    private String name;
    
    @Column(name = "per_address", nullable = true)
    private String address;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    public Person() {
    }

    public Person(String cpf, String name, String address) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
