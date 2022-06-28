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
- [예제1](./src/main/java/me/java8/DefaultFooMain.java) [예제2](./src/main/java/me/java8/DefaultFoo.java) [예제3](./src/main/java/me/java8/FooInterface.java)
- 인터페이스 기본 메서드 (default method)
  - default 접근제어자가 붙은 인터페이스는 꼭 재정의 하지 않아도 구현체에서 사용이 가능하다.
  - 상황에 따라 런타임 에러가 발생할 수도 있으므로 implSpec 애노테이션으로 스펙을 명시해준다.
  - object 에서 제공하는 메서드는 default 재정의가 불가능하다.
  - 구현체가 재정의 할 수도 있다.
  - 상속받는 인터페이스에서 다시 추상 메서드로 변경할수도 있다.
  - 충돌하는 default 메서드가 있는 경우 컴파일 에러가 발생한다. => 직접 오버라이딩 해야한다.
- 인터페이스 스태틱 메서드 (static method)
  - 해당 타입에 대한 유틸리티 메서드를 제공할때 보통 사용한다.

### Some useful default Methods of JAVA8 API
- Iterable
  - forEach
  - spliterator
- Collection
  - stream / parallelStream
  - removeIf(Predicate)
  - spliterator
- Comparator
  - reversed
  - thenComparing

## Stream
### Introduce
- 스트림으로 처리하는 데이터 소스(원본)은 수정하지 않는다.
- 오직 한번만 처리된다.
- 무제한일수도 있다. (Short Circuit 을 사용해서 제한할 수도 있다.)
- 스트림 파이프라인
  - 다수의 중개 오퍼레이션과 한개의 종료 오퍼레이션으로 구성(아예 없거나)
  - 종료 오퍼레이션(terminal operation) 을 실행될 때 데이터 소스를 처리함 (lazy)
- 중개/종료 오퍼레이션
  - 중개 오퍼레이터
    - **Stream 을 리턴한다**
    - 이전 상태 값을 참조하는 stateful 한 오퍼레이션이 존재한다.
  - 종료 오퍼레이터
    - Stream 을 리턴하지 않는다

## Optional
### Introduce
- 값을 제대로 리턴할 수 없는 경우
  - 예외를 던진다 (Stack Trace 를 찍어두기 때문에 비용이 발생한다)
  - null 을 리턴한다. (고전적인 널체크 방식으로 체크를 해야하는데 빠뜨릴 리스크가 있다.)
  - (JAVA8) Optional 을 리턴한다.
- Optional 사용시 주의점
  - 리턴 값으로만 사용해야 한다.(매개변수, 맵의 키, 인스턴스 필드 등으로 사용하지 말자.)
  - Optional 리턴타입에서 Null 을 리턴하면 안된다. (널체크 비용이 또 발생)
  - 원시타입용 Optional 은 따로 있다. (Optional 에 넣으면 박싱 언박싱으로 성능 저하)
  - Collection, Map 등 자체적으로 *비어있음* 을 나타낼 수 있는 객체에 사용하지 말 것

## Date Time
- 새로운 Date Time API 가 생긴 이유
  - Thread Safe (Immutable)
  - 클래스 이름이 명시적임
  - 버그 발생 여지가 많았음 (타입 안정성)

## JAVA Concurrent Programming
### Executors
- [예제 코드](./src/main/java/me/java8/section2/ConcurrentApp.java)
- 개발자가 Thread 를 직접 다루면 너무 복잡해지기 때문에 나온 고수준 인터페이스
- 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리해서 Executors 에게 위임
- 쓰레드 생성, 주기 관리, 실행 등의 작업을 수행한다.



