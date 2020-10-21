package com.thoughtworks.capability.gtb.restfulapidesign;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulApiDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiDesignApplication.class, args);
    }
}
