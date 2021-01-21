package com.example.core.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityCoreConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity webSecurity) throws Exception {
    // 정적리소스 접근에는 시큐리티 필터 적용하지 않는다.
    webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
  }

  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    // 모든 사이트 스피링 시큐리티 인증 없이 접근 허용 ( Test )
    http
      .cors().and()
      .csrf().disable()
      .authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated();

  }

}
