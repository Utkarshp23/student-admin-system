/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repositories;

import com.example.entities.Admin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hcdc
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    
    @Query("select a from Admin a where a.username=?1 and a.password=?2")
    public Optional<Admin> getAdminByUnameAndPwd(String uname, String pwd);
    
    @Query("select a from Admin a where a.username=?1")
    public Admin getAdminByUname(String uname);
    
}
