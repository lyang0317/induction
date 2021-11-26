package com.test.calculate;

public class BitTest {

    public static void main(String[] args) {
        int a = 1;//0 0...001
        System.out.println(a << 1);
        System.out.println(a >> 1);
        System.out.println(a >>> 1);
        int b = -1;//1 0...001
        System.out.println(b << 1);
        System.out.println(b >> 1);
        System.out.println(b >>> 1);

        int c = 2147483647 + 1;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(-2147483648));
        //Integer.parseInt不能转负进制
        System.out.println(Integer.parseInt("10", 2));
        System.out.println(-2147483648 - 1);
    }

}
