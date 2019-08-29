package com.ics.demo.models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull(groups = Student.Update.class)
    @Column(name="id")
    private Long id;

    @NotNull(groups = Student.Create.class)
    @Column(name="first_name")
    private String firstName;

    @NotNull(groups = Student.Create.class)
    @Column(name="last_name")
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="dob")
    private String dob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Student(){}

    public Student(String firstName, String lastName, String middleName, String dob){

        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dob = dob;
    }

    public interface Create{}
    public interface Update{}
}
