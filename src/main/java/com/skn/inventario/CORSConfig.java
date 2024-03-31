package com.skn.inventario;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // URL de tu API
                .allowedOrigins("http://localhost:3000") // Origen permitido, puede ser tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Métodos permitidos
    }
}
