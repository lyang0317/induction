package com.test.construct;

public class SonClass extends FatherClass {

    public int a = 2;

    public static String flag = "son";

    public SonClass() {
        System.out.println("son construct");
    }

    static {
        System.out.println("son static block");
    }

    {
        System.out.println("son block");
    }

}
