package com.example.executorserviceoverview;

import com.example.executorserviceoverview.com.Task;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Async
public class SingleThreadExample {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void callOnSingleThread() throws InterruptedException {
        try {
            long threadId = Thread.currentThread().getId();
//            executorService.submit(() -> System.out.println("in Runnable with threadId:"+threadId));
            Future<Task> res = executorService.submit(new Task("Single task"));
            System.out.println(res.get().getResult());
            executorService.shutdown();
        }
        catch(Exception ex) {
            executorService.shutdownNow();
        }
        finally {
            executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
            if(!executorService.isTerminated()) {
                executorService.shutdownNow();
            }
        }
    }
}
