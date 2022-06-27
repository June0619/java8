package me.java8.section2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        //기존의 널체크
//        Progress progress = spring_boot.getProgress();
//        if (progress != null) {
//            Duration studyDuration = progress.getStudyDuration();
//            System.out.println(studyDuration);
//        }

        Optional<OnlineClass> springOptional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean springPresent = springOptional.isPresent();
        System.out.println("springPresent = " + springPresent);

        Optional<OnlineClass> jpaOptional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        //Optional 에서 바로 값을 꺼내 사용하는건 권장하지 않는다.
//        OnlineClass jpaClass = jpaOptional.get();

        //ifPresent 활용 예시
        springOptional.ifPresent(oc -> System.out.println(oc.getTitle()));

        //orElse 는 optional 객체의 내용이 존재하더라도 실행된다.
        //상수 등으로 이미 만들어져 있는 필드를 가져오는 경우는 사용 해도 된다.
        jpaOptional.orElse(new OnlineClass(10, "new JPA", true));
        //인스턴스를 새로 만들어야 하는 경우엔 orElseGet 을 사용하는 것이 낫다.
        jpaOptional.orElseGet(() -> new OnlineClass(10, "new JPA", true));
        //orElseThrow 의 경우 없는 경우 예외를 던진다.
        springOptional.orElseThrow(IllegalStateException::new);

        //Optional 객체의 filter
        Optional<OnlineClass> emptyOptional =
                jpaOptional.filter(oc -> oc.getId() > 10);

        //Optional 객체의 flatMap
        Optional<Progress> optionalProgress = jpaOptional.flatMap(OnlineClass::getProgress);

        //위 코드와 동일한 기능
//        Optional<Optional<Progress>> progress = jpaOptional.map(OnlineClass::getProgress);
//        Optional<Progress> progress1 = progress.orElse(Optional.empty());




    }
}
