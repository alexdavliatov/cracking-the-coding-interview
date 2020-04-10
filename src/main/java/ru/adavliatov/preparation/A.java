package ru.adavliatov.preparation;

class A {
    private static final class B extends A { 
        static void f1() {
            System.out.println("f1 in B"); 
        }; 
 
        public static void f2() { 
            System.out.println("f2 in B"); 
        }; 
    } 
 
    static void f1() {
        System.out.println("f1 in A"); 
    }; 
 
    public static void f2() { 
        System.out.println("f2 in A"); 
    }; 
 
    public static void main(String[] args) { 
        B.f1(); 
        f2(); 
    } 
} 