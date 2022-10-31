package com.neb.subject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {
        "com.neb.subject.configuration",
        "com.neb.subject.mapper",
        "com.neb.subject.repository",
        "com.neb.subject.service",
        "com.neb.subject.controller"
})
public class SubjectApplication {
    public static void main(String[] args) {

        SpringApplication.run(SubjectApplication.class, args);
    }
}
