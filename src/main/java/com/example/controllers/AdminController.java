/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.entities.Admin;
import com.example.entities.Login;
import com.example.repositories.AdminRepository;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    
    @RequestMapping(value = "/login/admin")
    public ModelAndView showLoginPage(ModelMap model) {
              model.addAttribute("user_type", "admin");
              return new ModelAndView("loginpage","login",new Login());
    }
    
    @RequestMapping(value="/logincheck/admin")
    public String loginCheck(@ModelAttribute("login") Login lg,ModelMap model){

//        System.out.println(lg.getUsername());
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
            model.addAttribute("admin",a);
            return "redirect:/adminhomepage";
//            return "adminhomepage";
//            return new RedirectView("adminhomepage");
        }
        model.addAttribute("errmsg","Invalid username or password");
        model.addAttribute("user_type", "admin");
        return "errorpage";
//         return new RedirectView("errorpage");
    }
    
    @RequestMapping(value="/signup/admin")
    public ModelAndView adminSignup( ModelMap model)
    {
       model.addAttribute("user_type","admin");
       return new ModelAndView("signuppage","admin",new Admin());
    }
    
    @RequestMapping(value="/save/admin")
    public ModelAndView saveAdmin(@ModelAttribute("admin") Admin adm,ModelMap model)
    {
        Admin a=admrepo.getAdminByUname(adm.getUsername());
        if(a!=null)
        {
             String errmsg="Username already available! Enter another username";
             model.addAttribute("user_type", "admin");
             return new ModelAndView("errorpage","errmsg",errmsg);
        }
        admrepo.save(adm);
        model.addAttribute("user_type", "admin");
                
       return new ModelAndView("loginpage","login",new Login());
    }
    
   
    
    @RequestMapping(value="/adminhomepage")
    public String returnAdmHome(Model model,Principal pnpl)
    {
//        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
//        UserDetails ud=(UserDetails) auth.getPrincipal();
//        model.addAttribute("admin",ud);
        
        String username=pnpl.getName();
        Admin a=admrepo.getAdminByUname(username);
        model.addAttribute("user", a);
        model.addAttribute("user_type", "admin");
        return "adminhomepage";
    }
    
//    @RequestMapping(value="/logout")
//    public String logout()
//    {
//        return "/";
//    }
    
}
