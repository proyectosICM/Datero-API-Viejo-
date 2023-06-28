package com.b.dateroapi.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://192.168.0.214", "http://192.168.0.214:8084", "http://181.224.251.187:8084")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
