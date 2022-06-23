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

### 람다 표현식
- [예제](./src/main/java/me/java8/LambdaMain.java)
- 인자 타입은 컴파일러가 추론하기도 하고 명시할수도 있다.
- 바디의 경우 한줄일 경우 클로저 및 return 생략 가능
- 로컬 클래스 vs 익명 클래스 vs 람다
  - 로컬 클래스와 익명 클래스는 별도의 Scope 를 가진다.
  - 람다는 람다 함수를 선언한 스코프와 동일한 Scope 를 가진다.

### 메소드 레퍼런스
- [예제](./src/main/java/me/java8/MethodReferenceMain.java)
- 기존 메소드를 호출해서 사용하는 경우 메소드 레퍼런스를 통해 존재하는 메서드를 활용할 수 있다.
- 메소드 참조 종류
  - 스태틱 메소드 참조 (type::staticMethod)
  - 인스턴스 메소드 참조 (objectRef::instanceMethod)
  - 임의 객체 인스턴스 메소드 참조 (type::instanceMethod)
  - 생성자 참조 (type::new)

## 인터페이스의 변화
- 인터페이스 기본 메서드 (default method)
  - default 접근제어자가 붙은 인터페이스는 꼭 재정의 하지 않아도 구현체에서 사용이 가능하다.
  - 상황에 따라 런타임 에러가 발생할 수도 있으므로 implSpec 애노테이션으로 스펙을 명시해준다.
  - object 에서 제공하는 메서드는 default 재정의가 불가능하다.
  - 구현체가 재정의 할 수도 있다.
  - 상속받는 인터페이스에서 다시 추상 메서드로 변경할수도 있다.
  - 충돌하는 default 메서드가 있는 경우 컴파일 에러가 발생한다. => 직접 오버라이딩 해야한다.
- 인터페이스 스태틱 메서드 (static method)
  - 해당 타입에 대한 유틸리티 메서드를 제공할때 보통 사용한다.


