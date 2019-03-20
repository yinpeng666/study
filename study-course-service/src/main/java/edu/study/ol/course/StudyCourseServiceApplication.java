package edu.study.ol.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("edu.study.ol")
@MapperScan("edu.study.ol.course.mapper")
public class StudyCourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyCourseServiceApplication.class, args);
    }
}
