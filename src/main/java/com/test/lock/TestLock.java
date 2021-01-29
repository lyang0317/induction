package com.test.lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * FileName: TestLock
 * Author:   lujy7
 * Date:     2021/1/27 13:37
 * Description:
 */
public class TestLock {


    public static void main(String[] args) {
        testReadWriteLock();
    }

    private static void testLock() {
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep 5 seconds between 1 and 2");
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("thread 2 lock");
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println("thread 2 unlock");
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep 1 seconds between 2 and 3");
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("thread 3 lock");
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println("thread 3 unlock");
                }
            }
        }).start();
        System.out.println("main end");
    }

    public static void testInterrupt() {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程启动了");
                try {
                    Thread.sleep(1000 * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束了");
            }
        };
        thread.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();//作用是：在线程阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
    }

    private static void testReadWriteLock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantReadWriteLock.writeLock().lock();
                    System.out.println("thread 1 lock");
                    Thread.sleep(5000);
                    reentrantReadWriteLock.readLock().lock();
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantReadWriteLock.readLock().unlock();
                    System.out.println("thread 1 unlock");
                }
            }
        }).start();
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep 5 seconds between 1 and 2");
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantReadWriteLock.readLock().lock();
                    System.out.println("thread 2 lock");
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantReadWriteLock.readLock().unlock();
                    System.out.println("thread 2 unlock");
                }
            }
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep 5 seconds between 2 and 3");
        new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantReadWriteLock.readLock().lock();
                    System.out.println("thread 3 lock");
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantReadWriteLock.readLock().unlock();
                    System.out.println("thread 3 unlock");
                }
            }
        }).start();*/
        System.out.println("main end");
    }
}
