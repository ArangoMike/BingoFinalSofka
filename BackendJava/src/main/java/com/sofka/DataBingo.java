package com.sofka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DataBingo {

	public static void main(String[] args) {
		SpringApplication.run(DataBingo.class, args);
                
                
                
	}
        /* Configuración cors para poder consumir el servicio desde la url del cliente, en este caso,
        *  como ejercicio practico.
        */
        @Bean
        public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:52490").allowedMethods("*").allowedHeaders("*");
			}
		};
	   }

}
