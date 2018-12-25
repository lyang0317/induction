package com.test;

import com.test.construct.FatherClass;
import com.test.construct.SonClass;
import com.test.extend.Father;
import com.test.extend.SonA;
import com.test.extend.SonB;
import com.test.lock.MyLock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    static ReentrantLock rl = new ReentrantLock();
    static MyLock ml = new MyLock();

    static class A {
        public String show(D obj) {
            return "DinA";
        }
        public String show(A obj) {
            return "AinA";
        }
    }

    static class B extends A {
        public String show(B obj) {
            return "BinB";
        }
        public String show(A obj) {
            return "AinB";
        }
    }

    static class C extends B {
        public String show(C obj) {
            return "CinC";
        }
    }

    static class D extends B {
        public String show(B obj) {
            return "BinD";
        }
    }


    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 23, 29};
        int[] b = {4, 9, 18, 19};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
        /*byte xx = 1;
        byte yy = 123;
        System.out.println(xx);
        System.out.println(yy);
        char zz = (char) ('0'+xx);
        System.out.println(zz);


        FatherClass f = new SonClass();
        System.out.println("========");
        int i = 1;
        int x = i++ + i;
        System.out.println(x);
        System.out.println("============");
        List<String> list = new ArrayList<>();
        list.add("bb");
        String aa = "123" + list;
        System.out.println(aa);
        System.out.println("123" + new Father());
        System.out.println("===============");
        Father f1 = new SonA();
        f1.add("sonA");
        Father f2 = new SonB();
        f2.add("sonB");
        System.out.println(f1);
        System.out.println(f2);

        A a = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println(b.show(b));
        System.out.println(a.show(c));
        System.out.println(a.show(d));


        System.out.println(reverse(964632351));


        int a1 = 0xffff;
        a1 = 011;
        System.out.println(a);*/
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
       /* Father s = new SonClass();*/
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

    private static Integer reverse(int x) {
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
