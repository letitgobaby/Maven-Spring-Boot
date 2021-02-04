package com.example.admin.config;

import com.example.core.config.SecurityCoreConfig;
import com.example.core.security.JwtAuthenticationFilter;
import com.example.core.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Order(1)
@Configuration
public class SecurityConfig extends SecurityCoreConfig {

  private static final String[] ROLEUSER = new String[] {
    "/api/posts", "/api/counts"
  };

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Bean
  public PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

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
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // http.csrf().disable();
    http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    http
      .authorizeRequests()
        .antMatchers("/api/member/**").permitAll()
        .antMatchers(ROLEUSER).hasAnyAuthority("ADMIN", "ROLE_USER", "ROLE_ADMIN")
        .antMatchers("/api/**").hasAuthority("ADMIN")
        .anyRequest().authenticated();
 
    http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
  }

}
