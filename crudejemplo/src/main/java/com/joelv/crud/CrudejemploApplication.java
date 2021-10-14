package com.joelv.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        }
)
public class CrudejemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudejemploApplication.class, args);

    }

}
