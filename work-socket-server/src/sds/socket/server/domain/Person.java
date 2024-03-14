/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author matheus.buschermoehl
 */
@Entity
@Table(name = "tbperson")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    
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
