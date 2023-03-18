package com.ll.level1.p77884;

import java.util.Arrays;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int sum = IntStream.rangeClosed(left, right).filter(v -> v%Math.sqrt(v) == 0).sum();
        int answer =IntStream.rangeClosed(left,right).sum() - sum*2;
        System.out.println(answer);
    }
}
