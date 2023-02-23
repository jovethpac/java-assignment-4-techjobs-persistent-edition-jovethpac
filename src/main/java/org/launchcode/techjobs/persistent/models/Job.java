package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity{ //extends AbstractEntity and remove id, name and getters and setters and hash equals

    @ManyToOne //many jobs to one employer
    private Employer employer;//manyToOneEmployer is a made up variable

    @ManyToMany
    private List<Skill> manySkills; //= new ArrayList<>(); //manySkills is a variable I made up which I will use later at Skill.java Skill
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;

    //private String employer;

    public Job() { //empty constructor
    }

    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.manySkills = someSkills;
    }

    public Employer getEmployer(){
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Iterable<Skill> getManySkills() {
        return manySkills;
    }

    public void setManySkills(List<Skill> manySkills) {
        this.manySkills = manySkills;
    }


    // Getters and setters.

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getEmployer() {
//        return Employer;
//    }
//
//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
}
