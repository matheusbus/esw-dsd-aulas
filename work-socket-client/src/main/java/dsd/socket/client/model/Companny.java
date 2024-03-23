/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class Companny {
    
    private Integer id;
    private String cnpj;
    private String socialReason;
    private Integer foundedId;
    private List<Person> people = new ArrayList<>();

    public Companny() {
    }

    public Companny(Integer id, String cnpj, String socialReason, Integer foundedId) {
        this.id = id;
        this.cnpj = cnpj;
        this.socialReason = socialReason;
        this.foundedId = foundedId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public Integer getFoundedId() {
        return foundedId;
    }

    public void setFoundedId(Integer foundedId) {
        this.foundedId = foundedId;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
    
    
}
