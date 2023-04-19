package com.ll.level3.p12946;

import java.util.*;

public class main {
    public static void main(String[] args) {
        new Solution().solution(5);
    }
}

class Solution {
    public int[][] solution(int n) {
        List<int[]> li = new ArrayList<>();
        li = move(1, 3, n, li);
        int[][] answer = li.stream().toArray(int[][]::new);
        return answer;
    }

    private List<int[]> move(int CurrentPosition, int TargetPosition, int size, List<int[]> answer) {
        //나머지 포지션
        int AnotherPosition = 6 - CurrentPosition - TargetPosition;

        //종료 조건
        if (size == 1) {
            answer.add(new int[]{CurrentPosition, TargetPosition});
            return null;
        }
        //점화식 (c, t, size) = (c, a, size-1) + (c, t, 1) + (a, t, size-1)
        move(CurrentPosition, AnotherPosition, size - 1, answer);
        move(CurrentPosition, TargetPosition, 1, answer);
        move(AnotherPosition, TargetPosition, size - 1, answer);
        return answer;
    }
}