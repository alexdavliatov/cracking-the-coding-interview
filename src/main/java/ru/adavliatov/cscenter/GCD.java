package ru.adavliatov.cscenter;

public class GCD {
    public long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new GCD().gcd(-15, 20));
        System.out.println(new GCD().gcd(-20, 15));
    }
}
