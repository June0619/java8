# JAVA8

> [백기선 - 더 자바, JAVA 8 강의내용 요약 레포](https://www.inflearn.com/course/the-java-java8/dashboard) 


## 함수형 인터페이스
- [예제](./src/main/java/me/java8/RunSomething.java)
- Interface 내부에 Static, Default 메서드 추가 가능하다
- 함수형 인터페이스 내에는 추상화 메서드가 단 하나만 존재해야 한다
- Static, Default 메서드 존재 하더라도 **추상화 메서드**가 하나만 존재하면 함수형 인터페이스

### 함수형 프로그래밍의 조건
- 일급객체
- 고차함수
  - 함수를 매개변수로 받거나 함수를 리턴하는 함수
- 순수함수
  - 함수 밖에 있는 값을 가져다 사용하지 않는다.
  - 함수 밖에 있는 값을 수정하지 않는다.


### 자바에서 기본으로 제공하는 함수형 인터페이스
- [예제](./src/main/java/me/java8/BasicFunctionalInterfacesMain.java)
- java.lang.function 패키지
  - Function<T,R>
  - BiFunction<T,U,R>
  - Consumer<T>
  - Supplier<T>
  - Predicate<T>
  - UnaryOperator<T>
  - BinaryOperator<T>
