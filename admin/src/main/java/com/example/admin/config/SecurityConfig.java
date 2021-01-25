package com.example.admin.config;

import com.example.core.config.SecurityCoreConfig;
import com.example.core.security.JwtAuthenticationFilter;
import com.example.core.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.Collections;

@Order(1)
@Configuration
public class SecurityConfig extends SecurityCoreConfig {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  // 암호화에 필요한 PasswordEncoder 를 Bean 등록합니다.
  @Bean
  public PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  // authenticationManager를 Bean 등록합니다.
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .headers().frameOptions().disable()
      .and()
      .csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository());

    // http
    //   .authorizeRequests()
    //     .antMatchers("/h2-console").permitAll()
    //     .antMatchers("/api/user/*").permitAll()
    //     .antMatchers("/test/**").permitAll()
    //     .antMatchers("/**").authenticated();

    http.authorizeRequests().antMatchers("/**").permitAll();

    http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

  }

  // protected void configure(HttpSecurity http) throws Exception {
  // http
  // .csrf().disable()
  // .addFilterBefore(CorsFilter , UsernamePasswordAuthenticationFilter.class)
  // .exceptionHandling()
  // .authenticationEntryPoint(unauthorizedHandler)
  // .accessDeniedHandler()
  // .and()
  // .headers().frameOptions().sameOrigin()
  // .and()
  // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
  // .and()
  // .authorizeRequests().antMatchers("/**").permitAll()
  // .anyRequest().authenticated()
  // .and()
  // .apply(securityConfigurerAdapter());
  // }

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {

  // http.csrf().disable();

  // http
  // .headers().frameOptions().disable()
  // .and()
  // .authorizeRequests()
  // // .antMatchers("/favicon.ico").permitAll()
  // .antMatchers("/h2-console/**").permitAll();

  // http
  // .cors().and()
  // .authorizeRequests()
  // // .antMatchers("/member").hasRole("ADMIN")
  // // .antMatchers("/").hasAnyRole("ADMIN","USER")
  // .antMatchers("/api/posts/*").permitAll()
  // .antMatchers("/api/user/*").permitAll()
  // .anyRequest().authenticated()
  // .and()
  // .csrf()
  // .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

  // }

}
