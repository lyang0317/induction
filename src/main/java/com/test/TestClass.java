package com.test;

public class TestClass {

    public synchronized void printA() {
        System.out.println("A start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
    }

    public synchronized void printB() {
        System.out.println("B start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");
    }

    public void printC() {
        System.out.println("C start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }

}
