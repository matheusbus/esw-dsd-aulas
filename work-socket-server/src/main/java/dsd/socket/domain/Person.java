package dsd.socket.domain;

import jakarta.persistence.*;

import java.io.Serializable;
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
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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

    public String toStringWithNoCompany() {
        return new StringBuilder()
                .append(this.getClass().getSimpleName() + ";")
                .append(cpf + ";")
                .append(name + ";")
                .append(address + ";")
                .toString();
    }
}
