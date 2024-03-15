package dsd.socket.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 *
 * @author matheus.buschermoehl
 */
@Entity
@Table(name = "tbemployee")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "emp_position", nullable = false)
    private String position;
    
    @Column(name = "emp_salary", nullable = false)
    private Double salary;
    
    @Column(name = "emp_active", nullable = false)
    private Boolean active;

    public Employee() {
    }

    public Employee(String position, Double salary, Boolean active, String cpf, String name, String address) {
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
        return "Employee{" + "position=" + position + ", salary=" + salary + ", active=" + active + '}';
    }
    
}
