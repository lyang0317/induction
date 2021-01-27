package com.test.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * FileName: TestLock
 * Author:   lujy7
 * Date:     2021/1/27 13:37
 * Description:
 */
public class TestLock {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("thread 1 lock");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println("thread 1 unlock");
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("thread 2 lock");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println("thread 2 unlock");
                }
            }
        }).start();
        System.out.println("main end");
    }

}
