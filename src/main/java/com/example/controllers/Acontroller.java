/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.entities.Admin;
import com.example.entities.Login;
import com.example.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hcdc
 */
@Controller
public class Acontroller {
    
    @Autowired
    AdminRepository admrepo;
    
    @RequestMapping(value = "/")
    public String showHomePage() {
//            List<Admin> admlist=(List<Admin>) admrepo.findAll();
//            System.out.println("Hello.....");
            return "index";
    }
    
    @RequestMapping(value = "/login")
    public ModelAndView showLoginPage() {
//            List<Admin> admlist=(List<Admin>) admrepo.findAll();
//            for(Admin a:admlist)
//            {
//                System.out.println(a.getFname());
//                System.out.println(a.getLname());
//            }
//            System.out.println("Hello.....");
//            return "home";
              return new ModelAndView("loginpage","login",new Login());
    }
    
    @RequestMapping(value="/logincheck")
    public String loginCheck(@ModelAttribute("login") Login lg){
//        Admin a=admrepo.getAdminByUnameAndPwd(lg.getUsername(),lg.getPassword());
        System.out.println(lg.getUsername());
        Admin a;
        Optional<Admin> adm=admrepo.getAdminByUnameAndPwd(lg.getUsername(),lg.getPassword());
        try{
            a=adm.get();
            System.out.println("Inside try....."+a.getFname());
        }
        catch(Exception e){
            a=null;
        }
        
        if(a!=null)
        {
            return "adminhomepage";
        }
        return "errorpage";
    }
    
}
