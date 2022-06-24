package me.java8.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Java8APIMain {

    public static void main(String[] args) {

        //SplitIterator
        List<String> splitIteratorArr = getNameArr();

        Spliterator<String> spliterator1 = splitIteratorArr.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("============================");
        while (spliterator2.tryAdvance(System.out::println));

        System.out.println("============Stream================");

        //Stream
        List<String> streamArr = getNameArr();

        long j = streamArr.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("J"))
                .count();

        System.out.println("j = " + j);

        System.out.println("============================");

        //removeIf
        List<String> removeIfArr = getNameArr();

        removeIfArr.removeIf(s -> s.startsWith("j"));
        removeIfArr.forEach(System.out::println);

        System.out.println("============================");


    }

    public static List<String> getNameArr() {
        List<String> nameArr = new ArrayList<>();
        nameArr.add("jwjung");
        nameArr.add("toby");
        nameArr.add("alpha");
        nameArr.add("beta");

        return nameArr;
    }
}
