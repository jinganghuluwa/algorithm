package com.example.subsequence;

/**
 * Created by tongzhichao on 17-6-22.
 */

public class MainClass {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, -4, 5, -6};
        int b = maxsubsequence(a, 0, a.length - 1);
        System.out.println("one result is " + b);
        b = maxsubsequence(a);
        System.out.println("two result is " + b);
    }

    private static int maxsubsequence(int[] a, int left, int right) {
        int maxleft, maxright;
        int submaxleft = 0, submaxright = 0;
        int subleft = 0, subright = 0;
        int center;
        if (left == right) {
            return a[left] > 0 ? a[left] : 0;
        }
        center = (left + right) / 2;
        maxleft = maxsubsequence(a, left, center);
        maxright = maxsubsequence(a, center + 1, right);
        for (int i = center; i >= left; i--) {
            subleft += a[i];
            if (subleft > submaxleft) {
                submaxleft = subleft;
            }
        }
        for (int i = center + 1; i <= right; i++) {
            subright += a[i];
            if (subright > submaxright) {
                submaxright = subright;
            }
        }
        return maxThree(maxleft, maxright, (submaxleft + submaxright));
    }

    private static int maxThree(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    private static int maxsubsequence(int a[]) {
        int thissub = 0, maxsub = 0;
        for (int i = 0; i < a.length; i++) {
            thissub += a[i];
            if (thissub > maxsub) {
                maxsub = thissub;
            } else if (thissub < 0) {
                thissub = 0;
            }
        }
        return maxsub;
    }
}
