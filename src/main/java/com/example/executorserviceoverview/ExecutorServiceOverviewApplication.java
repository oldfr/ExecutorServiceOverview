package com.example.executorserviceoverview;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class ExecutorServiceOverviewApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		SpringApplication.run(ExecutorServiceOverviewApplication.class, args);

		// each one below have 2 versions,
		// one with explicit Thread Factory and other with no Thread Factory (where defaultThreadFactory is used to create threads)

		//single Thread - Creates an Executor that uses a single worker thread
/*       SingleThreadExample singleThreadExample = new SingleThreadExample();
        singleThreadExample.callOnSingleThread();*/

		//fixed threads - Creates a thread pool that reuses a fixed number of threads
/*		FixedThreadsExample fixedThreadsExample = new FixedThreadsExample();

        //get all data
		fixedThreadsExample.getAllData();

        // to get anyData processed first
        fixedThreadsExample.getAnyData();*/

		//cached threads - Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available
/*		CachedThreadsExample cachedThreadsExample = new CachedThreadsExample();
		cachedThreadsExample.callOncachedThread();*/

		// scheduled threads - Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
//		ScheduledThreadsExample scheduledThreadsExample = new ScheduledThreadsExample();
//		scheduledThreadsExample.callOnScheduledThread();


	}

}
