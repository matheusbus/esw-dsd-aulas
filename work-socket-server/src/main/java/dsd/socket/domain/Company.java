package dsd.socket.domain;

import jakarta.persistence.*;

import java.util.List;

/**
 *
 * @author matheus.buschermoehl
 */
@Entity
@Table(name = "tbcompany")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "com_id")
    private Integer id;
    
    @Column(name = "com_cnpj", unique = true, nullable = false)
    private String cnpj;
    
    @Column(name = "com_socialreason", nullable = false)
    private String socialReason;
    
    @Column(name = "com_foundedin")
    private Integer foundedIn;
        
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Person> people;

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
        return "Company{" + "socialReason=" + socialReason + ", cnpj=" + cnpj + ", foundedIn=" + foundedIn + ", people=" + people + '}';
    }
    
}
