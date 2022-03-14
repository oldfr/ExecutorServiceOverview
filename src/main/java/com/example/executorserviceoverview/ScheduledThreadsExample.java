package com.example.executorserviceoverview;

import com.example.executorserviceoverview.com.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ScheduledThreadsExample {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public ScheduledThreadsExample() {
    }

    public void callOnScheduledThread() throws InterruptedException, ExecutionException {
        ScheduledFuture scheduledFuture = null;
        try {
            Task task = new Task("Scheduled Task");
            scheduledFuture = executorService.schedule(
                    task, 5, TimeUnit.SECONDS);
            executorService.shutdown();
            String res = String.valueOf(scheduledFuture.get());
            System.out.println("got " + res);
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex);
            executorService.shutdownNow();
        } finally {
            executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
            if (!executorService.isTerminated()) {
                executorService.shutdownNow();
            }
        }
    }

}