package com.ll.level1.p86491;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {80, 40}, {60, 30}};
        int[][] sizes1 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        new Solution().solution(sizes1);
    }
}
class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int[] mins = new int[len];
        int[] maxs = new int[len];

        //사이즈 저장
        for(int i = 0 ; i < len; i++){
            mins[i] = Math.min(sizes[i][0], sizes[i][1]);
            maxs[i] = Math.max(sizes[i][0], sizes[i][1]);
        }
        //size에서 가장 큰 사이즈 찾기
        int minlen = Arrays.stream(mins).max().getAsInt();
        int maxlen = Arrays.stream(maxs).max().getAsInt();

        return minlen*maxlen;
    }
}