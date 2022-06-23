package me.java8;

public class DefaultFooMain {

    public static void main(String[] args) {

        FooInterface foo = new DefaultFoo("june");
        foo.printName();
        foo.printNameUpperCase();
    }
}
