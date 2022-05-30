package com.example.executorserviceoverview.com;

import java.util.concurrent.Callable;

public class Task implements Callable {

//    ExecutorService executorService = Executors.newFixedThreadPool(5);
    private String name;
    private String result;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Task call() {
        System.out.println("running tasks:"+this.getName()+" in thread:"+Thread.currentThread().getId());
        /*if(this.getName().equals("Task 3")) {
        }*/
        this.result = "completed task:"+this.getName();
        return this;
    }
}
