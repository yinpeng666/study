package edu.study.ol.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("edu.study.ol")
@MapperScan(basePackages = "edu.study.ol.user.mapper")
public class StudyUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUserServiceApplication.class, args);
    }
}
