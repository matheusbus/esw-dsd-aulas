package dsd.socket.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 *
 * @author matheus.buschermoehl
 */
@Entity
@Table(name = "tbcompany")
@Data
@Builder
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbcompany_id_seq")
    @SequenceGenerator(name="tbcompany_id_seq", sequenceName = "tbcompany_id_seq", initialValue = 4)
    @Column(name = "com_id")
    private Integer id;

    @NotBlank(message = "O CNPJ não pode estar em branco")
    @Column(name = "com_cnpj", unique = true, nullable = false)
    private String cnpj;

    @NotBlank(message = "Razão social não pode estar em branco")
    @Column(name = "com_socialreason", nullable = false)
    private String socialReason;

    @Min(value = 1900, message = "Ano de fundação deve ser maior ou igual a 1900")
    @NotNull(message = "Ano de fundação não pode ser nulo")
    @Column(name = "com_foundedin")
    private Integer foundedIn;
        
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Double calculatePayRoll() {
        AtomicReference<Double> payRoll = new AtomicReference<>(0.00);

        people.forEach(p -> {
            if(p instanceof Employee) {
                payRoll.updateAndGet(v -> v + ((Employee) p).getSalary());
            }
        });

        return payRoll.get();
    }

    public Double calculateAccountsReceivable() {
        AtomicReference<Double> payRoll = new AtomicReference<>(0.00);

        people.forEach(p -> {
            if(p instanceof Customer) {
                payRoll.updateAndGet(v -> v + ((Customer) p).getBalanceDue());
            }
        });

        return payRoll.get();
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
                    .map(person -> person.toStringWithNoCompany().replace(";", "%%"))
                    .collect(Collectors.joining("##"));

            result.append("[").append(peopleAsString).append("]");
        } else {
            result.append("[]");
        }

        return result.toString();
    }
}
