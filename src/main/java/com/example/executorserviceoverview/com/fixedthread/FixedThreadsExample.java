package com.example.executorserviceoverview.com.fixedthread;

import com.example.executorserviceoverview.com.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/****
 * Calling the get() method while the task is still running will cause execution to block until the task properly executes and the result is available.
 *
 * With very long blocking caused by the get() method, an application's performance can degrade. If the resulting data is not crucial, it is possible to avoid such a problem by using timeouts:
 * like:- String result = future.get(200, TimeUnit.MILLISECONDS);
 */

public class FixedThreadsExample {

    static ExecutorService executorService;

    public FixedThreadsExample() {
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("===========InvokeAll()========\n\n");
        getAllData();
        System.out.println("\n\n===========InvokeAny()========\n\n");
        getAnyData();
    }
    public static void getAllData() throws InterruptedException, ExecutionException {
        executorService = Executors.newFixedThreadPool(4);
        Future<String> future = null;
        List<Future<Task>> futuresList = new ArrayList<>();
        List<Callable<Task>> tasks = new ArrayList<>();
        try {
            for(int i =0;i<5;i++) {
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

    public static void getAnyData() throws InterruptedException {
        executorService = Executors.newFixedThreadPool(4);
        List<Callable<Task>> tasks = new ArrayList<>();
        try {
            for(int i =0;i<5;i++) {
                Task task = new Task("Task "+i);
                tasks.add(task);
            }
            Task str = executorService.invokeAny(tasks);
            System.out.println("first "+str.getResult());
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
    }


}
