package com.geely.design.pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RankTest {

    public static void main(String[] args) {
        int[] inputs = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            inputs[i] = random.nextInt(500);
        }

        Arrays.sort(inputs);
        System.out.print("input:[");
        for (int i = 0; i < 99; i++) {
            System.out.print(inputs[i]+",");
        }
        System.out.println(inputs[99]);

        int index = random.nextInt(100);
        int realIndex = binarySearch(inputs, inputs[index]);
        System.out.println("搜索的值是："+inputs[index]);
        System.out.println("理论索引是:    " + index + "\n实际索引是：  " + realIndex);

        HashMap hashMap = new HashMap();
    }

    public static int binarySearch(int[] inputs, int goal) {
        int lo = 0;
        int hi = inputs.length;
        return binarySearch(inputs, goal, lo, hi);
    }

    private static int binarySearch(int[] inputs, int goal, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi)/2;
        if (goal < inputs[mid]) return binarySearch(inputs, goal, lo ,mid);
        else if (goal > inputs[mid]) return binarySearch(inputs, goal, mid, hi);
        else return mid;
    }
}
