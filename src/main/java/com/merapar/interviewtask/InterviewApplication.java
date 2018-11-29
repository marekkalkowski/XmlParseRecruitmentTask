package com.merapar.interviewtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class InterviewApplication {

    public static void main(String[] args) {

        ApplicationContext cfx =  SpringApplication.run(InterviewApplication.class, args);



    }
}
