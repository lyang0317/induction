package com.test;

import com.test.lock.MyLock;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

    static ReentrantLock rl = new ReentrantLock();
    static MyLock ml = new MyLock();

    public static void main(String[] args) {
        System.out.println(reverse(123));


        int a = 0xffff;
        a = 011;
        System.out.println(a);
       /* a = 1111111111111111
        System.out.println(a);*/
        /*try {
            URL resource = Test.class.getResource("");
            Class<?> regexUtils = new MyClassLoader(resource.getPath()).loadClass("com.lyang.android.tools.RegexUtils");
            //Class<?> regexUtils = Class.forName("com.lyang.android.tools.RegexUtils");
            Method[] methods = regexUtils.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
       /* FatherClass s = new SonClass();*/
        /*final TestClass testClass = new TestClass();
        new Thread(new Runnable() {
           public void run() {
               testClass.printA();
           }
       }).start();
        new Thread(new Runnable() {
            public void run() {
                testClass.printB();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                testClass.printC();
            }
        }).start();*/
    }

    private static Integer reverse(Integer x) {
        if(x == 0)
            return 0;
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(x);
        boolean zeroFlag = false;
        boolean negativeFlag = false;
        for(int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            if('-' == c) {
                negativeFlag = true;
                continue;
            }
            if('0' != c) {
                zeroFlag = true;
            }
            if(zeroFlag) {
                sb.append(String.valueOf(c));
            }
        }
        Integer integer = Integer.valueOf(sb.toString());
        return negativeFlag ? 0-integer : integer;
    }

    private static void reentrantLockTest() {
    /*ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    CountDownLatch cdl = new CountDownLatch(1);*/

        new Thread(new Runnable() {
            public void run() {
                rl.lock();
                System.out.println("thread 1 lock1");
                /*rl.lock();
                System.out.println("thread 1 lock2");*/
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rl.unlock();
                System.out.println("thread 1 unlock1");
                /*rl.unlock();
                System.out.println("thread 1 unlock2");*/
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean b = rl.tryLock();
                System.out.println(b);
                rl.lock();
                System.out.println("thread 2 lock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rl.unlock();
                System.out.println("thread 2 unlock");
            }
        }).start();
    }

    private static void myLockTest() {
    /*ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    CountDownLatch cdl = new CountDownLatch(1);*/

        new Thread(new Runnable() {
            public void run() {
                ml.lock();
                System.out.println("thread 1 lock");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ml.unlock();
                System.out.println("thread 1 unlock");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*boolean b = ml.tryLock();
                System.out.println(b);*/
                ml.lock();
                System.out.println("thread 2 lock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ml.unlock();
                System.out.println("thread 2 unlock");
            }
        }).start();
    }

}
