package com.example.executorserviceoverview.com.singlethread;

import com.example.executorserviceoverview.com.Task;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.*;

@Async
public class SingleThreadExample {

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
     //    public void callOnSingleThread() throws InterruptedException {

        Callable<String> callable = () -> {
            return "Single Task, running on thread "+Thread.currentThread().getId();
        };
        try {
            Future<String> res = executorService.submit(callable);
            System.out.println(res.get());
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
