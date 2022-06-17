# JAVA8

## 함수형 인터페이스

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
