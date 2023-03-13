package com.ll.level0.p120905;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12}));
    }
}

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = new int[numlist.length];
        int idx = 0;
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0)
                answer[idx++] = numlist[i];
        }
        return Arrays.copyOf(answer, idx);
    }
}
class SolutionV2 {
    public int[] solution(int n, int[] numList) {
        return Arrays.stream(numList).filter(value -> value % n == 0).toArray();
    }
}