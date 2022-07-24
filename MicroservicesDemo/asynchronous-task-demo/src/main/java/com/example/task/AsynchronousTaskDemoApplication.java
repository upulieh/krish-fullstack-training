package com.example.task;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.example.task.service.RentProcessTaskRunner;

//whole purpose of this service is to handle this one task
@SpringBootApplication
@EnableTask
public class AsynchronousTaskDemoApplication {

	@Bean //adding @Service or @Component on top of the class does the same too
	RentProcessTaskRunner getRentProcessTaskRunner() {
		return new RentProcessTaskRunner();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AsynchronousTaskDemoApplication.class, args);
	}

}
