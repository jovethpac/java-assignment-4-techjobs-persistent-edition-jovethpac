package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;

@Entity
public class Job extends AbstractEntity{ //extends AbstractEntity and remove id, name and getters and setters and hash equals

//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;

    //private String employer;
    private String Employer;
    private String skills;

    public Job() { //empty constructor
    }

    public Job(String anEmployer, String someSkills) {
        super();
        //this.employer = anEmployer;
        this.Employer = anEmployer;
        this.skills = someSkills;
    }

    @ManyToOne //many jobs to one employer
    private Employer manyToOneEmployer; //manyToOneEmployer is a made up variable
    // Getters and setters.

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getEmployer() {
        return Employer;
    }

    public void setEmployer(String employer) {
        this.Employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
