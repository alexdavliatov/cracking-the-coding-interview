package ru.adavliatov.preparation;

public class InitOrder {
    static int val;
    static {
        System.out.println("static 1");
        //0
        System.out.println("val = " + val);
    }

    int val1;
    {
        System.out.println("non-static 1");
        System.out.println(val1);
    }

    public static void main(String[] args) {
        System.out.println("main");
        new InitOrder();
    }

    static {
        System.out.println("static 2");
        System.out.println("val = ");
    }

    public InitOrder() {
        System.out.println("constructor");
    }

    {
        System.out.println("non-static 2");
    }
}
