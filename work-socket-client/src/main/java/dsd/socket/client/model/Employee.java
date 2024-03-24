/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.model;

/**
 *
 * @author Matheus
 */
public class Employee extends Person {
 
    private String position;
    private Double salary;
    private Boolean active;
    
    public Employee(String cpf, String name, String address, String position, Double salary, Boolean active) {
        super(cpf, name, address);
        this.position = position;
        this.salary = salary;
        this.active = active;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
            .append(this.getPosition() + ";")
            .append(this.getSalary() + ";")
            .append(this.getActive().toString())
            .toString();
    }
    
}
