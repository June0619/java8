package me.java8;

public class RunSomethingMain {

    public static void main(String[] args) {

        //아래 코드와 내부적으로 동일한 동작
        RunSomething runSomething = () -> System.out.println("Hello");
        runSomething.doIt();

        //익명 내부 클래스 anonymous inner class
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        //순수함수 예시
        int someNumber = 10;
        PureFunction pfi = (number) -> {

            //외부 값에 의존하거나 외부 값을 건드리면 순수 함수가 아니게 된다.
//            return number + someNumber;
            return number + 10;
        };

        //같은 값을 인자로 넣으면 같은 반복을 보장해야한다.
        pfi.doIt(10);
        pfi.doIt(10);
        pfi.doIt(10);


    }
}
