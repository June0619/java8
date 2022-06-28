package me.java8.section3;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
public class AnnotationApp {

    public static void main(String[] args) {

        //애노테이션의 값 출력
        Chicken[] chickens = AnnotationApp.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        //컨테이너 타입으로 출력
        ChickenContainer chickenContainer = AnnotationApp.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });

    }
}
