package com.test;

import java.util.Random;

public class WorkTest {

    private static int STEP = 0;

    public static void main(String[] args) {
        long nextIndex = 116864003;
        long itemType = 4;
        long counterAndTypeCode = nextIndex << 15 | itemType;
        System.out.println(counterAndTypeCode);
        long upperWithoutBit43 = (counterAndTypeCode & 0xFFFFF80000000000L) << 1;
        System.out.println(upperWithoutBit43);
        long lowerWithoutBit43 = counterAndTypeCode & 0x7FFFFFFFFFFL;
        System.out.println(lowerWithoutBit43);
        System.out.println(upperWithoutBit43 | 0x80000000000L | lowerWithoutBit43);


        /*System.out.println("------ step list ------");
        getStep(3);
        System.out.println("------- step num -----");
        System.out.println(STEP);*/
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
