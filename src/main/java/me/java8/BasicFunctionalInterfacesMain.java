package me.java8;

import java.util.function.*;

public class BasicFunctionalInterfacesMain {

    public static void main(String[] args) {

        //Function<T, R>
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        System.out.println("Function1 : " + plus10.apply(10));

        //Function 인터페이스는 두 함수를 조합할 수 있다.
        System.out.println("Function2 : " + plus10.compose(multiply2).apply(2));

        //Consumer<T>
        Consumer<Integer> printT = (i) -> System.out.println("Consumer : " + i);
        printT.accept(10);

        //Supplier<T>
        Supplier<Integer> get10 = () -> 10;
        System.out.println("Supplier : " + get10.get());

        //Predicate<T>
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println("Predicate : " + isEven.test(10));

        //UnaryOperator<T>
        UnaryOperator<Integer> plus10Unary = (i) -> i + 10;
        System.out.println("Unary : " + plus10Unary.apply(10));

    }
}
