package edu.study.ol.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.study.ol")
public class StudyUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUserWebApplication.class, args);
    }
}
