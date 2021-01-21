package com.example.admin.config;

import com.example.core.config.SecurityCoreConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


// @Configuration
public class SecurityConfig extends SecurityCoreConfig {
  
  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //     http
  //             .authorizeRequests()
  //                 .antMatchers("/*").permitAll()
  //                 .anyRequest().authenticated()
  //                 .and()
  //             .formLogin()
  //                 .defaultSuccessUrl("/")
  //                 .permitAll()
  //                 .and()
  //             .logout();
  // }
  
}
