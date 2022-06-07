package com.example.executorserviceoverview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class ExecutorServiceOverviewApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(ExecutorServiceOverviewApplication.class, args);
	}

}
