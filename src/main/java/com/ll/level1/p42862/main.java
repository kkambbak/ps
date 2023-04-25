package com.ll.level1.p42862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        new Solution().solution(5, new int[]{2, 3, 4}, new int[]{1, 2, 3});
    }
}

class Solution {
    public int solution(int n, int[] lostArr, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> losts = Arrays.stream(lostArr).sorted().boxed().collect(Collectors.toCollection(ArrayList::new));
        Arrays.sort(reserve);
        ArrayList<Integer> reserve2 = new ArrayList<>();

        for (int i : reserve) {
            if (losts.contains(i)) {
                losts.remove(losts.indexOf(i));
            } else {
                reserve2.add(i);
            }
        }

        if (reserve2.size() == 0 || losts.size() == 0) return n - losts.size();

        for (int i : reserve2) {

            if (losts.contains(i - 1)) {
                losts.remove(losts.indexOf(i - 1));
            } else if (losts.contains(i + 1)) {
                losts.remove(losts.indexOf(i + 1));
            }
        }
        answer = n - losts.size();
        System.out.println(answer);
        return answer;
    }
}