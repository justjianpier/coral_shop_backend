package com.coralshop.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoralShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoralShopApplication.class, args);
        System.out.println("¡Servidor de Coral Shop iniciado correctamente!");
    }

}
