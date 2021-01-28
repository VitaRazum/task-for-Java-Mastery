package com.mastery.java.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.mastery.java.task.config",
 // "com.mastery.java.task.dao", "com.mastery.java.task.dto", "com.mastery.java.task.rest", "com.mastery.java.task.service"})
@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

}
