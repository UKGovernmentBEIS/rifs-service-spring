package uk.gov.rifs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Spring Boot Application Started ............");
        SpringApplication springApplication = new SpringApplication();
        SpringApplication.run(Application.class, args);
    }
}

