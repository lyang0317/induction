package com.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test {

    private static CountDownLatch countDownLatch;
    private static CyclicBarrier cyclicBarrier;
    private static Object obj = new Object();

    public static void main(String[] args) {
        countDownLatch = new CountDownLatch(2);
        cyclicBarrier = new CyclicBarrier(12);

        final Thread thread1 = new Thread(new Runnable() {

            public void run() {
                System.out.println("thread 1");
                for (int i = 0; i < 5; i++) {
                    try {
                        synchronized (obj) {
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread 1 num : " + i);
                }
            }
        });
        thread1.start();
       /* System.out.println("thread 1 interrupt : " + thread1.isInterrupted());
        thread1.interrupt();
        System.out.println("thread 1 interrupt : " + thread1.isInterrupted());*/

        Thread thread2 = new Thread(new Runnable() {

            public void run() {
                System.out.println("thread 2");
                for (int i = 0; i < 5; i++) {
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread 2 num : " + i);
                }
            }
        });
        thread2.start();
        System.out.println("thread 2 interrupt : " + thread2.isInterrupted());

        Thread thread3 = new Thread(new Runnable() {

            public void run() {
                System.out.println("thread 3");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            }
        });
        thread3.start();

        System.out.println("end");
    }

}
