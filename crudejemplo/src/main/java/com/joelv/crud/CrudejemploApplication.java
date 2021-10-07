package com.joelv.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        }
)
public class CrudejemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudejemploApplication.class, args);

    }

}
