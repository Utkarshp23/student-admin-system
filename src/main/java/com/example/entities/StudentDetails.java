/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author hcdc
 */
@Entity
@Table(name="studentdetails")
public class StudentDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id 
    private Integer id;
    
    @Column
    private String full_name;
    
    @Column
    private String email;
    
    @Column
    private String dept;
    
    @Column
    private String phone_no;
    
    @Column
    private byte[] photo;
    
    
//    FetchType.LAZY -->Load the entities whenever needed
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Student student;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentDetails(Integer id, String full_name, String email, String dept, String phone_no, byte[] photo, Student student) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.dept = dept;
        this.phone_no = phone_no;
        this.photo = photo;
        this.student = student;
    }

    
    
    public StudentDetails() {
    }

//    public StudentDetails(Integer id, String full_name, String email, String dept, String phone_no, byte[] photo) {
//        this.id = id;
//        this.full_name = full_name;
//        this.email = email;
//        this.dept = dept;
//        this.phone_no = phone_no;
//        this.photo = photo;
//    }
    
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof StudentDetails)) {
            return false;
        }
        StudentDetails other = (StudentDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentDetails{" + "id=" + id + ", full_name=" + full_name + ", email=" + email + ", dept=" + dept + ", phone_no=" + phone_no + ", photo=" + photo + ", student=" + student + '}';
    }

    
    
}
