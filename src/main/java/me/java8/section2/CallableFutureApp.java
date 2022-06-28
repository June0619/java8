package me.java8.section2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started");

        //cancel 실행 후 get 호출 시 Exception 발생
//        helloFuture.cancel(false);

        //Blocking Call
        //get 으로 값을 가져올 때 까지 기다린다.
        helloFuture.get();

        System.out.println(helloFuture.isDone());
        System.out.println("End");

        //invoke 예제
        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> jiwoon = () -> {
            Thread.sleep(2000L);
            return "jiwoon";
        };

        //모든 작업이 완료될 때 까지 기다린다.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, jiwoon));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        //가장 먼저 종료된 스레드의 값만 가져온다.
        String s = executorService.invokeAny(Arrays.asList(hello, java, jiwoon));
        System.out.println(s);

        executorService.shutdown();
    }
}
