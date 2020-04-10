package ru.adavliatov.preparation;

import jdk.jshell.EvalException;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class Generics {
    private Generics() {
    }

    class C extends Generics {

    }

    public static void main(String[] args) {

        new Generics().new C().new C();

        new Generics();
    }
}