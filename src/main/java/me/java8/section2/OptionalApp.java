package me.java8.section2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OptionalApp {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);

        //기존의 널체크
//        Progress progress = spring_boot.getProgress();
//        if (progress != null) {
//            Duration studyDuration = progress.getStudyDuration();
//            System.out.println(studyDuration);
//        }



    }
}
