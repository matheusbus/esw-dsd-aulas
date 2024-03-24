/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Matheus
 */
public class Company {
    
    private Integer id;
    private String cnpj;
    private String socialReason;
    private Integer foundedIn;
    private List<Person> people = new ArrayList<>();

    public Company() {
    }

    public Company(Integer id, String cnpj, String socialReason, Integer foundedIn, List<Person> people) {
        this.id = id;
        this.cnpj = cnpj;
        this.socialReason = socialReason;
        this.foundedIn = foundedIn;
        this.people = people;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getFoundedIn() {
        return foundedIn;
    }

    public void setFoundedIn(Integer foundedIn) {
        this.foundedIn = foundedIn;
    }

    public List<Person> getPeople() {
        return people;
    }
    
    public boolean removePerson(Person person) {
        if(this.people.indexOf(person) != -1) {
            return this.people.remove(person);
        }
        return false;
    }
    
    public boolean addPerson(Person person) {
        if(this.people.indexOf(person) != -1) {
            return false;
        }
        return this.people.add(person);
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
                .append(id).append(";")
                .append(cnpj).append(";")
                .append(socialReason).append(";")
                .append(foundedIn).append(";");

        if (people != null && !people.isEmpty()) {
            String peopleAsString = people.stream()
                    .map(person -> person.toString())
                    .collect(Collectors.joining(","));

            result.append("[").append(peopleAsString).append("]");
        } else {
            result.append("[]");
        }

        return result.toString();
    }
    
    
    
}
