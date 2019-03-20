package edu.study.ol.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.study.ol")
public class StudyManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyManageWebApplication.class, args);
    }
}
