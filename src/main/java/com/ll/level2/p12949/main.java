package com.ll.level2.p12949;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        new Solution().solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}});
    }
}
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                answer[i][j] = product(arr1, arr2, i, j);
            }
        }
        return answer;
    }

    int product(int[][] arr1, int[][] arr2, int y, int x) {
        int num = 0;
        for (int i = 0; i < arr1[0].length; i++) {
            num += (arr1[y][i] * arr2[i][x]);
        }
        return num;
    }
}