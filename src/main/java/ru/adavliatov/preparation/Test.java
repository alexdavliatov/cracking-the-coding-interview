package ru.adavliatov.preparation;

public class Test {
    static int f(int x) throws RuntimeException {
        if (x == -2) return -2;



        return f(x - 1);
    }

    void main() {
        f(3);
    }
}
