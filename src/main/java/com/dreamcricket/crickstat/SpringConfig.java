package com.dreamcricket.crickstat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("Setting CORS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        registry.addMapping("/**").allowedOrigins("http://localhost:4200");
    }
}
