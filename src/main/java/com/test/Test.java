package com.test;

import com.test.classloader.MyClassLoader;
import com.test.construct.FatherClass;
import com.test.construct.SonClass;
import com.test.lock.MyLock;

import javax.lang.model.SourceVersion;
import javax.tools.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    static ReentrantLock rl = new ReentrantLock();
    static MyLock ml = new MyLock();

    public static void main(String[] args) {
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
