package me.java8.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExApp {

    public static void main(String[] args) {

        List<String> names = getNameArr();

        // map 과 같은 중개형 오퍼레이터는 종료형 오퍼레이터가 존재하지 않으면 실행조차 안된다.
        List<String> upperNames = names.stream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                //다음과 같이 종료형 오퍼레이터가 붙고 나면 실행된다.
                .collect(Collectors.toList());
        System.out.println("===================");
        upperNames.forEach(System.out::println);
        System.out.println("===================");
        //원본 데이터는 변경되지 않는다.
        names.forEach(System.out::println);
        System.out.println("===================");
        //멀티 스레드 처리 예시
        //멀티 스레드라고 무조건 빠른건 아니다. 싱글 스레드가 더 빠른 경우가 많다.
        List<String> collect = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);
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
