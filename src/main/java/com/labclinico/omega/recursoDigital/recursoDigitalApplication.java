package com.labclinico.omega.recursoDigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class recursoDigitalApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(recursoDigitalApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(recursoDigitalApplication.class, args);
    }
}
