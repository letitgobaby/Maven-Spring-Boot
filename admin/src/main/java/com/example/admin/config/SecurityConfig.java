package com.example.admin.config;

import com.example.core.config.SecurityCoreConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Order(1)
@Configuration
public class SecurityConfig extends SecurityCoreConfig {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {



    // http.csrf().disable();
    // http
    //   .authorizeRequests()
    //     .antMatchers("/", "/login", "/login-error").permitAll()
    //     .antMatchers("/member/**").hasRole("ADMIN")
    //     .antMatchers("/**").permitAll();
    http
      .cors().and()
      .authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated();
  

    http.logout()
      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
      .logoutSuccessUrl("/login")
      .invalidateHttpSession(true);

  }
  
}
