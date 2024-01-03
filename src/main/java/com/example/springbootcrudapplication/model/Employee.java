package com.example.springbootcrudapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "first_name")
    String fName;

    @Column(name = "last_name")
    String lName;

    @Column(name = "email_id")
    String emailId;
}
