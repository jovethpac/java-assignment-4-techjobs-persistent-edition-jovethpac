package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Skill extends AbstractEntity {


    @NotBlank
    @Size(min=3, max=255)
    private String description;

    @ManyToMany(mappedBy = "manySkills")
    private List<Job> jobs= new ArrayList<>();

    public Skill() {
    }

//    public Skill(String description) {
//        this.description = description;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Skill skill = (Skill) o;
//        return Objects.equals(description, skill.description);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), description);
//    }
}