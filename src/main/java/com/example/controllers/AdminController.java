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
public class AdminController {
    
    @Autowired
    AdminRepository admrepo;
    
    @RequestMapping(value = "/")
    public String showHomePage() {
            return "index";
    }
    
    @RequestMapping(value = "/login")
    public ModelAndView showLoginPage() {
              return new ModelAndView("loginpage","login",new Login());
    }
    
    @RequestMapping(value="/logincheck")
    public String loginCheck(@ModelAttribute("login") Login lg){

        System.out.println(lg.getUsername());
        Admin a;
        Optional<Admin> adm=admrepo.getAdminByUnameAndPwd(lg.getUsername(),lg.getPassword());
        try{
            a=adm.get();
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
    
    @RequestMapping(value="/adminsignup")
    public ModelAndView adminSignup()
    {
       return new ModelAndView("adminsignup","admin",new Admin());
    }
    
    @RequestMapping(value="/save")
    public ModelAndView saveAdmin(@ModelAttribute("admin") Admin adm)
    {
        Admin a=admrepo.getAdminByUname(adm.getUsername());
        if(a!=null)
        {
             String errmsg="Username already available! Enter another username";
             return new ModelAndView("errorpage","errmsg",errmsg);
        }
        admrepo.save(adm);
       return new ModelAndView("loginpage","login",new Login());
    }
    
}
