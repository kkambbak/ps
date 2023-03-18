package com.ll.level1.p12910;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = {3,2,6};
        int divisor = 50;
        int[] answer = {};
        answer = Arrays.stream(arr).sorted().filter(v-> v%divisor==0).toArray();
        if(Arrays.equals(answer,new int[]{})) answer= new int[]{-1};
        System.out.println(Arrays.toString(answer));
        // sort를 따로 빼면 속도가 더 빨라진다?
    }
}
