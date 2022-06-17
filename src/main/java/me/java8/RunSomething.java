package me.java8;

@FunctionalInterface
public interface RunSomething {

    //추상메서드가 하나만 있는 경우 함수형 인터페이스
    //스태틱 메서드나 디폴트 메서드가 존재하더라도 **추상화** 메서드가 하나만 존재하면 함수형 인터페이스이다.
    void doIt();

    //두번째 메서드가 존재하면 안된다.
//    void doItAgain();

    //자바8 추가기능1
    //인터페이스 내부에 스태틱 메서드 정의 가능
    static void printStatic() {
        System.out.println("print staticMethod");
    }

    //자바8 추가기능2
    //인터페이스 내부에 디폴트 메서드 정의 가능
    default void printDefault() {
        System.out.println("print defaultMethod");
    }
}
