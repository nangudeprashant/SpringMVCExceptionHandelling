package com.javaLive.configuration;  
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
  
@Configuration 
@ComponentScan("com.javaLive.controller") 
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {  
	@Bean  
    public UrlBasedViewResolver urlBasedViewResolver() {  
      UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
      resolver.setPrefix("/views/");  
      resolver.setSuffix(".jsp");
      resolver.setViewClass(JstlView.class);  
      return resolver;  
    }
	@Bean
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
	  SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
      Properties errorMaps = new Properties();
      errorMaps.setProperty("ElectricityNotFoundException", "error");
      errorMaps.setProperty("NullPointerException", "error");
      resolver.setExceptionMappings(errorMaps);
      resolver.setDefaultErrorView("globalerror");
      resolver.setExceptionAttribute("exc");
      return resolver;
   }
}  
 