package com.swd.lambda.ex1;

public class Hello {

    public static void main(String[] args) {

        //public static void print(IHello hello)
        IHello iHello = ()->{ return ("Hello world!"); };

        //Simplifying
        IHello iHello2 = () -> "Hello world simplified!";

        System.out.println(iHello.printHello());
        System.out.println(iHello2.printHello());
    }

}
