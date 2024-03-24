/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.model;

/**
 *
 * @author Matheus
 */
public class Person {
    
    protected String cpf;
    protected String name;
    protected String address;
    protected Company company;
    
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
        this.company.addPerson(this);
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
            .append(cpf + ";")
            .append(name + ";")
            .append(address + ";")
            .append(companyString)
            .toString();
    }
}
