package com.ll.level0.p120840;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        int balls = 30;
        int share = 15;
        long answer = 1;
        for(int i=balls; i> Math.max(share,balls-share); i--){
            answer *= i;
        }
        for(int i=1; i<= Math.min(share,balls-share); i++){
            answer /= i;
        }

        System.out.println(answer);
    }
}
class Solution {
    public long solution(int n, int r) {

        if (r > n / 2) {
            r = n - r; // nCr = nC(n-r)
        }
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= n - r + i;
            result /= i;
        }
        return result;
    }
}