/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.config;

import com.example.entities.Admin;
import com.example.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author hcdc
 */

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
     @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService1();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
//        auth
//                .inMemoryAuthentication()
//                .withUser("utkarsh")
//                .password("utk23")
//                .roles("admin");    
        auth.userDetailsService(userDetailsService());
    }
    
    @Bean
    PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    
     @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        
        http.authorizeRequests()
                .antMatchers("/adminhomepage").authenticated()
                .antMatchers("/studenthomepage").authenticated()
                .antMatchers("/","/login/**","/signup/**","save/**").permitAll() //,"/login/**"
//                .and()
//                .formLogin().loginPage("/login/admin").loginProcessingUrl("/logincheck/admin").defaultSuccessUrl("/adminhomepage")
                .and()
                .formLogin().loginPage("/login/student").loginProcessingUrl("/logincheck/student").defaultSuccessUrl("/studenthomepage")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest()
//                .authenticated() ; //.denyAll()  || .permitAll()
//                .and()
//                .csrf().disable();
//                .and()
//                .httpBasic();    //.and().formLogin()

//                 .formLogin().loginPage("/web/login").permitAll()
    }
    
    
    
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        
//           return username -> admrepo.getAdminByUname(username)
//                   .map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole())))
//                   .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
//    }
//    
//    
//    @Bean
//    public DaoAuthenticationProvider authProvider(){
//        DaoAuthenticationProvider aProvider= new DaoAuthenticationProvider();
//        aProvider.setUserDetailsService(userDetailsService());
////        aProvider.
//        return aProvider;
//    }
//    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authMgr) throws Exception{
//        authMgr.authenticationProvider(authProvider());
//    }

   
}
