package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "org.example")
public class PgApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgApplication.class, args);
    }

}
