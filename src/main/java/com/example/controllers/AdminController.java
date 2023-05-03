/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.entities.Admin;
import com.example.entities.Login;
import com.example.entities.Student;
import com.example.entities.StudentDetails;
import com.example.repositories.AdminRepository;
import com.example.services.StudentDetailsService;
import com.example.services.StudentService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.security.crypto.codec.Base64;

/**
 *
 * @author hcdc
 */
@Controller
public class AdminController {
    
    @Autowired
    AdminRepository admrepo;
    
    @Autowired
    StudentService stdservice;
    
    @Autowired
    StudentDetailsService stdDetService;
    
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
        adm.setRole("ADMIN");
        admrepo.save(adm);
        model.addAttribute("user_type", "admin");
                
       return new ModelAndView("loginpage","login",new Login());
    }
    
   
    
    @RequestMapping(value="/adminhomepage")
    public String returnAdmHome(HttpServletRequest request,Model model,Principal pnpl)
    {
//        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
//        UserDetails ud=(UserDetails) auth.getPrincipal();
//        model.addAttribute("admin",ud);
        
        String username=pnpl.getName();
        Admin a=admrepo.getAdminByUname(username);
//        model.addAttribute("user", a);
        model.addAttribute("user_type", "admin");
         
        HttpSession session = request.getSession(false);
        session.setAttribute("user", a);
        return "adminhomepage";
    }
    
//    @RequestMapping(value="/logout")
//    public String logout()
//    {
//        return "/";
//    }
    
    @RequestMapping(value="/getallstudents")
    public String getAllStudents(Model model)
    {
        List<Student> studentList=stdservice.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "studentlist";
    }
    
    @RequestMapping("/studs")
    public ModelAndView getStuds(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size )
    {
        Page<Student> studsPage=stdservice.getStudsPage(page,size); 
        ModelAndView modv=new ModelAndView("studentlist");
        modv.addObject("studs", studsPage.getContent());
        modv.addObject("totalPages", studsPage.getTotalPages());
        modv.addObject("currentPage", page);
        return modv;
    }
    
    @RequestMapping("/viewdetails/{id}")
    public ModelAndView getStudentDetails(@PathVariable("id") int stdId)
    {
        StudentDetails stdDet=stdDetService.getStudentDetailsById(stdId);
//        response.getOutputStream().write(stdDet.getPhoto());
        return new ModelAndView("stdview","stddet",stdDet);
    }
    
    @RequestMapping("/showphoto/{id}")
    public void getPhoto(@PathVariable("id") int stdId,HttpServletResponse response,Model mav) throws IOException
    {
        StudentDetails stdDet=stdDetService.getStudentDetailsById(stdId);
//        byte [] bytes= stdDet.getPhoto();
//        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//        response.setContentLength(stdDet.getPhoto().length);
//        response.getOutputStream().write(stdDet.getPhoto());
//        response.getOutputStream().close();
//        InputStream inp= new ByteArrayInputStream(bytes);
//        IOUtils.copy(inp,response.getOutputStream());
            byte[] encodeBase64 = Base64.encode(stdDet.getPhoto());
            String base64Encoded = new String(encodeBase64, "UTF-8");
            mav.addAttribute("userImage", base64Encoded);
           
    }
    
    @GetMapping("/manageroles")
    public ModelAndView manageRoles()
    {
        Map<String,List<String>> roleFunctionMap= new HashMap<>();
        return new ModelAndView("manageroles","map",roleFunctionMap);
    }
            
    
}
