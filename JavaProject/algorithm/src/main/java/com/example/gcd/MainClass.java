package com.example.gcd;

/**
 * Created by tongzhichao on 17-7-10.
 */

public class MainClass {
    public static void main(String[] args) {
//        求两个数的最大公约数
        int a=9,b=7;
        System.out.println("result : "+gcd(a,b));
    }

    public static int gcd(int a, int b) {
        int tem;
        while (b > 0) {
            tem = a % b;
            a = b;
            b = tem;
        }
        return a;
    }
}
