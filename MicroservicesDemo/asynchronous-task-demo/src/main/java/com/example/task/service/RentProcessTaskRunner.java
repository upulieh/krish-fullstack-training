package com.example.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//similar to a command line application (similar to the main method) 
public class RentProcessTaskRunner implements CommandLineRunner {

	@Autowired
	RentProcessServiceImpl rentProcessService;

	// a real world use case might be to send an email/save the value in a db etc.
	@Override
	public void run(String... args) throws Exception {
		
		if (args.length > 0) {
			System.out.println("task running with arguments");
			if (rentProcessService.validateDL(args[0])) {
				System.out.println("valid driving license");
			} else {
				System.out.println("invalid driving license");
			}
		}else {
			System.out.println("task running without arguments");
		}
	}
}
