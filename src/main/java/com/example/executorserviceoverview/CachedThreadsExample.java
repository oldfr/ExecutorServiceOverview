package com.example.executorserviceoverview;

import com.example.executorserviceoverview.com.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CachedThreadsExample {
    static ExecutorService executorService = Executors.newCachedThreadPool();

    public CachedThreadsExample() {
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//    public void callOncachedThread() throws InterruptedException, ExecutionException {
        Future<String> future = null;
        List<Future<Task>> futuresList = new ArrayList<>();
        List<Callable<Task>> tasks = new ArrayList<>();
        try {
            for(int i =0;i<10;i++) {
                Task task = new Task("Task "+i);
                tasks.add(task);
            }
            futuresList = executorService.invokeAll(tasks);
            executorService.shutdown();
        }
        catch(Exception ex) {
            System.out.println("ERROR:"+ex);
            executorService.shutdownNow();
        }
        finally {
            executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
            if(!executorService.isTerminated()) {
                executorService.shutdownNow();
            }
        }
        for (Future<Task> futureRes : futuresList) {
            String task = String.valueOf(futureRes.get());
            System.out.println(task.toString());

        }
    }
}
