package com.swd.lambda.ex2;

public class Hello {

    public static void main(String[] args) {
        IHello iHello = (String name) -> {
            return ("Hello, " + name + "!");
        };

        //Simplifying
        IHello iHello2 = (name) -> "Hello, " + name + "!";

        System.out.println(iHello.printHelloWithName("Charlie"));
        System.out.println(iHello2.printHelloWithName("Mike"));
}

}
