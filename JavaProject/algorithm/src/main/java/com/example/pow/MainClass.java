package com.example.pow;

/**
 * Created by tongzhichao on 17-7-10.
 */

public class MainClass {
    public static void main(String[] args) {
//        m的n次幂
        int m = 9, n = 4;
        System.out.println("result : " + pow(m, n));
    }

    public static int pow(int m, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return m;
        } else if (isEven(n)) {
            return pow(m * m, n / 2);
        } else {
            return pow(m * m, n / 2) * m;
        }
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
