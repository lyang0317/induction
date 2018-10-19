package com.test;

import java.util.Random;

public class WorkTest {

    private static int STEP = 0;

    public static void main(String[] args) {
        System.out.println("------ step list ------");
        getStep(3);
        System.out.println("------- step num -----");
        System.out.println(STEP);
    }

    private static void getStep(int i) {
        if(i == 0) {
            return;
        }
        int i1 = new Random().nextInt(i) + 1;
        System.out.println(i1);
        STEP ++;
        getStep(i - i1);
    }

}
