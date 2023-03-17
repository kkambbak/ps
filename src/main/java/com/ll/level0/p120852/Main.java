package com.ll.level0.p120852;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Solution().solution(420);
    }
}
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int idx = 2;
        HashSet<Integer> set = new HashSet();

        while (n != 1){
            while(n%idx==0){
                n /= idx;
                set.add(idx);
            }
            idx++;
            System.out.println(idx);
        }
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}