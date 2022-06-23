package me.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class LambdaMain {
    public static void main(String[] args) {

        //BODY 내용이 한줄이라면 생략 가능
//        Supplier<Integer> get10 = () -> {
//            return 10;
//        };

        Supplier<Integer> get10 = () -> 10;
        BinaryOperator<Integer> summary = (a, b) -> a + b;

        LambdaMain lambdaMain = new LambdaMain();
        lambdaMain.run();
    }

    private void run() {

        final int baseNumber = 10;

        //로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println("LocalClass : " + baseNumber);
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;
                System.out.println("AnonymousClass : " + baseNumber);
            }
        };

        //람다에서 로컬 변수를 참조하고 있는 상황
        IntConsumer printInt = (i) -> {
            // ERR
//            int baseNumber = 11;
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
