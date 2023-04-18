package com.ll.level1.p42840;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        new Solution().solution(new int[]{1,3,2,4,2,1,3,2,4,2,1,3,2,4,2});
    }
}
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        final int[] p1 = {1, 2, 3, 4, 5};
        final int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int a1 = p1[i % 5];
            int a2 = p2[i % 8];
            int a3 = p3[i % 10];

            if (answers[i] == a1)
                count1++;
            if (answers[i] == a2)
                count2++;
            if (answers[i] == a3)
                count3++;
        }
        List<Integer> li = Arrays.asList(count1,count2,count3);
        int max = li.stream().max(Integer::compareTo).get();
        System.out.println(max);
        answer = IntStream.range(0, 3)
                .filter(i -> li.get(i).equals(max))
                .map(i -> i + 1)
                .toArray();

        return answer;
    }
}