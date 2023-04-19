package com.ll.level2.p42839;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        new Solution().solution("1234");
    }
}
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        System.out.println(isPrime(171));
        return answer;
    }

    boolean isPrime(int n) {
        if(n<=1) return false;
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    List<int[]> li = new ArrayList<>();
    void makeCombination(String numbers,int len){
        char[] num = numbers.toCharArray();
        if(len==1) {
            for (char n :
                    num) {
                li.add(new int[]{(int)n});
            }
            return;
        }
        makeCombination(numbers,len-1);
    }
}

class Combination {
    private static void recursion(int[] arr, int r, int index, List<Integer> tempList, List<List<Integer>> result) {

    }
}