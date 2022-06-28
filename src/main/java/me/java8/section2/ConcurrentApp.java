package me.java8.section2;

import java.util.concurrent.*;

public class ConcurrentApp {

    public static void main(String[] args) throws InterruptedException {

        //Executors
        Executor executor;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(getRunnable("executor"));

        //하던 작업은 모두 종료시킴
        executorService.shutdown();
        //당장 종료시킴
//        executorService.shutdownNow();

        //thread pool
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);

        executorService2.submit(getRunnable("one"));
        executorService2.submit(getRunnable("two"));
        executorService2.submit(getRunnable("three"));
        executorService2.submit(getRunnable("four"));

        executorService2.shutdown();

        //schedule
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("schedule"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }

}
