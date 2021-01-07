package com.example.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/resource.properties")
// @PropertySources({ @PropertySource("classpath:/resource.properties") })
public class WebConfig implements WebMvcConfigurer {

  @Value("${resources.location:}")
  private String resourcesLocation;

  @Value("${resources.uri_path:}")
  private String resourcesUriPath;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (StringUtils.hasText(resourcesLocation) && StringUtils.hasText(resourcesUriPath)) {
      registry.addResourceHandler(resourcesUriPath + "/**")
              .addResourceLocations("file://" + resourcesLocation);
    }
  }

}