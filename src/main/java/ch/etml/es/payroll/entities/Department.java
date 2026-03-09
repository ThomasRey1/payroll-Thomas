package ch.etml.es.payroll.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "departments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "acronym")
        }
)
public class Department {
    private @Id
    @GeneratedValue Long id;
    private String acronym;
    private String description;

    public Department(){}

    public Department(String acronym, String description){
        this.setAcronym(acronym);
        this.setDescription(description);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getAcronym(){
        return this.acronym;
    }

    public void setAcronym(String acronym){
        this.acronym = acronym;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Department department))
            return false;
        return  this.id.equals(department.id) &&
                this.acronym.equals(department.acronym) &&
                this.description.equals(department.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.acronym,
                this.description);
    }

    @Override
    public String toString(){
        return "Department{" + "id=" +
                this.id + ", acronym='" +
                this.acronym + '\'' + ", description='" +
                this.description + '\'' +
                '}';
    }
}
