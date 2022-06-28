package me.java8.section3;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelApp {

    public static void main(String[] args) {

        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        //1500개의 배열을 랜덤한 값으로 채운다.
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        //Quick Sort
        //O(n log(n))
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}
