package com.example.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@PropertySource("classpath:/application.properties")
@EnableJpaRepositories(basePackages = {"com.example.core.repository"})
@EntityScan(basePackages = {"com.example.core.model"})
public class Config {
}
