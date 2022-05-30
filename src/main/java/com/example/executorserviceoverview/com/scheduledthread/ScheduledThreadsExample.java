package com.example.executorserviceoverview.com.scheduledthread;

import com.example.executorserviceoverview.com.Task;

import java.util.concurrent.*;

public class ScheduledThreadsExample {
    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public ScheduledThreadsExample() {
    }

    public static void main(String[] args) throws InterruptedException {
//    public void callOnScheduledThread() throws InterruptedException, ExecutionException {
        ScheduledFuture scheduledFuture = null;
        try {
            Task task = new Task("Tablet");
            scheduledFuture = executorService.schedule(
                    task, 5, TimeUnit.SECONDS);
            executorService.shutdown();
            Task res = (Task) scheduledFuture.get();
            System.out.println("Completed Scheduled task:" + res.getName());
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
