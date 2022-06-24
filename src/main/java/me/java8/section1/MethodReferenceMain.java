package me.java8.section1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceMain {

    public static void main(String[] args) {

        //static method 참조
        UnaryOperator<String> hi = Greeting::hi;

        //instance method 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        //constructor 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting suppliedGreeting = newGreeting.get();

        //함수형 인터페이스에 따라 다른 종류의 생성자를 참조할 수도 있다.
        Function<String, Greeting> stringGreetingFunction =
                Greeting::new;
        Greeting gr = stringGreetingFunction.apply("greeting");
        System.out.println(gr.getName());

        //임의의 객체를 참조하는 것도 가능하다.
        String[] names = {"jwjung", "brokenBot", "ironman"};
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }
}
