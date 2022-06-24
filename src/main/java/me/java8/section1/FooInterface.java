package me.java8.section1;

public interface FooInterface {

    //초기 추상 메서드
    void printName();
    String getName();

    //추가된 메서드
    //런타임 에러가 발생할 수도 있으므로 implSpec 을 통해 기능을 명시한다.
    /**
     * @implSpec getName() 으로 가져온 문자열을 대문자로 바꾸어 출력
     * */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }
}
