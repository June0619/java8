package me.java8.section2;

import java.util.concurrent.*;

public class CompletableFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("hello");

        //위 코드와 동일
        CompletableFuture<String> future = CompletableFuture.completedFuture("hello");
        System.out.println(future.get());

        //리턴타입이 없는 경우
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("future1 : " + Thread.currentThread().getName());
        });
        future1.get();

        //리턴타입이 있는 경우
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 : " + Thread.currentThread().getName());
            return "future2";
        });
        System.out.println(future2.get());

        //CallBack 을 주는 경우
        CompletableFuture<String> waiting_call_back = CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting Call Back");
            return "CallBack";
        }).thenApply(s -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println(waiting_call_back.get());

        //리턴타입이 없는 경우
        CompletableFuture<Void> voidFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("VoidFuture : " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        voidFuture.get();

        //두개의 작업 조합
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("HelloFuture : " + Thread.currentThread().getName());
            return "Hello";
        });

        //예전 방식
//        hello.get();
//        getWorld().get();

        //compose 사용
        CompletableFuture<String> composedFuture = hello.thenCompose(CompletableFutureApp::getWorld);
        System.out.println(composedFuture.get());

        //두 작업이 연관관계가 없을 경우
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("WorldFuture : " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> combinedFuture = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(combinedFuture.get());

        //에러 처리
        CompletableFuture<String> exceptionFuture = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new IllegalStateException();
            }

            System.out.println("Exception : " + Thread.currentThread().getName());
            return "hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error";
        });

        System.out.println(exceptionFuture.get());

        //handle 예제
        CompletableFuture<String> handleFuture = CompletableFuture.supplyAsync(() -> {
            if (false) throw new IllegalStateException();

            System.out.println("Exception : " + Thread.currentThread().getName());
            return "hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "error";
            }
            return result;
        });

        System.out.println(handleFuture.get());


    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("WorldFuture : " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
