/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hcdc
 */
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    @Column
    private String fname;
    
    @Column
    private String lname;
    
    
//    delete orphaned entities from the database. An entity that is no longer attached to its parent is the definition of being an orphan. 
//    @OneToOne(mappedBy = "student",cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private StudentDetails details;
    
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentDetails details;

    public Student(Integer id, String fname, String lname, String username, String password, String role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Student(Integer id, String fname, String lname, StudentDetails details, String username, String password, String role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.details = details;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    

    public Student() {
    }

    @Column
    private String username;

    @Column
    private String password;
    
     @Column
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentDetails getDetails() {
        return details;
    }

    public void setDetails(StudentDetails details) {
        this.details = details;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.controllers.Student[ id=" + id + " ]";
    }
    
}
