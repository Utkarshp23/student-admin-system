package com.example.controllers;

import com.example.entities.Admin;
import com.example.entities.Login;
import com.example.entities.Student;
import com.example.repositories.StudentRepository;
import java.security.Principal;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {
    
    @Autowired
    StudentRepository strepo;
    
    @RequestMapping(value = "/login/student")
    public ModelAndView showLoginPage(ModelMap model) {
              model.addAttribute("user_type", "student");
              return new ModelAndView("loginpage","login",new Login());
    }
    
    @RequestMapping(value={"/logincheck/student"})
    public String loginCheck(@ModelAttribute("login") Login lg,ModelMap model){

//      System.out.println(lg.getUsername());
        Student s;
        Optional<Student> std=strepo.getStudentByUnameAndPwd(lg.getUsername(),lg.getPassword());
        try{
            s=std.get();
        }
        catch(Exception e){
            s=null;
        }
        
        if(s!=null)
        {
            model.addAttribute("student",s);
//          return "studenthomepage";
            return "redirect:/studenthomepage";
        }
        model.addAttribute("errmsg","Invalid username or password");
        model.addAttribute("user_type", "student");
        return "errorpage";
    }
    
    @RequestMapping(value="/signup/student")
    public ModelAndView studentSignup( ModelMap model)
    {
       model.addAttribute("user_type","student");
       return new ModelAndView("signuppage","student",new Student());
    }
    
    @RequestMapping(value="/save/student")
    public ModelAndView saveAdmin(@ModelAttribute("student") Student std,ModelMap model)
    {
        Student s=strepo.getStudentByUname(std.getUsername());
        if(s!=null)
        {
             String errmsg="Username already available! Enter another username";
             model.addAttribute("user_type", "student");
             return new ModelAndView("errorpage","errmsg",errmsg);
        }
        strepo.save(std);
        model.addAttribute("user_type", "student");
       return new ModelAndView("loginpage","login",new Login());
    }
    
    @RequestMapping(value="/studenthomepage")
    public String returnAdmHome(Model model,Principal pnpl)
    {
        String username=pnpl.getName();
        Student s=strepo.getStudentByUname(username);
        model.addAttribute("user", s);
        model.addAttribute("user_type", "student");
        return "studenthomepage";
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }  
}
