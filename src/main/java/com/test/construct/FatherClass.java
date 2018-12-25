package com.test.construct;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.List;
import java.util.Set;

public class FatherClass {

    public int a = 1;

    public static String flag = "father";

    public FatherClass() {
        Set l;
        System.out.println("father construct");
    }

    static {
        System.out.println("father static block");
    }

    {
        System.out.println("father block");
    }

}
