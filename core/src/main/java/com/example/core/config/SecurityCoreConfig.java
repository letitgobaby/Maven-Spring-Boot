package com.example.core.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityCoreConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity webSecurity) throws Exception {
    // 정적리소스 접근에는 시큐리티 필터 적용하지 않는다.
    // webSecurity.ignoring().antMatchers("/resources/**");

    webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    webSecurity.ignoring().antMatchers("/static/**", "/js/**", "/css/**", "/images/**", "/templates/**");
    webSecurity.ignoring().antMatchers("/manifest.json", "/**/*.png", "/**/*.woff", "/**/*.ttf", "/**/*.ico");

  }

}
