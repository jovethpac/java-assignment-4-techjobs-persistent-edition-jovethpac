package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Employer extends AbstractEntity {
//add a list of jobs here called jobs, use  18.3.2.1  add private final events...etc  use 18.2.2.1 add @OneToMany make sure it has mappedBy which is employer   ignore @JoinColumn
    @NotBlank
    @Size(min=3, max=255)
    private String location;

    public Employer() {
    }

    @OneToMany
    @JoinColumn(name="employer_id")
    private final List<Job> oneToManyjobs = new ArrayList<>();  //oneToManyjobs is a made up variable Job matches the Job class


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Employer employer = (Employer) o;
//        return Objects.equals(location, employer.location);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), location);
//    }
}
