package com.example.divide;

import java.text.NumberFormat;

/**
 * Created by tongzhichao on 17-6-27.
 * 某些分治算法将以O（N）时间运行，如果一个算法用常数时间将问题的大小削减为其一部分（通常是1/2），那么改算法就是O（logN）.
 * 如果使用常数时间只是把问题减少一个常数，那么这种算法就是O（N）的。
 */

public class MainClass {
    public static void main(String[] args) {
//        对分查找，给定一个整数X，和整数A0，A1,A2,A3,An-1,后者已经排序并在内存中，求是的Ai=X的下标i，不存在返回-1
        int x = 30;
        int[] a = {1, 5, 9, 17, 23, 22, 23, 24, 30, 45, 87, 100, 111, 234, 456, 7788};
        int result = one(x, a, 0, a.length - 1);
        System.out.println("one result is " + result);
        System.out.println("oneone result is " + oneone(x, a));
    }

    /**
     * 对分查找
     *
     * @return
     */

    private static int one(int x, int[] a, int left, int right) {
        if (left == right) {
            if (a[left] == x) {
                return left;
            } else {
                return -1;
            }
        }
        if (x == a[(left + right) / 2]) {
            return (left + right) / 2;
        } else if (x < a[(left + right) / 2]) {
            return one(x, a, left, (left + right) / 2);
        } else {
            return one(x, a, ((left + right) / 2) + 1, right);
        }
    }

    private static int oneone(int x, int[] a) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
