package com.ll.level2.p68645;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        new Solution().solution(6);
    }
}
class Solution {
    public int[] solution(int n) {
        int n1 = n;

        //삼각형 생성
        int[][] triangle = new int[n][n];
        int num = 1;
        int x = 0;
        int y = n-1;
        int count1 = 0;
        int count2 = 1;
        while(n>=1){
            for (int i = 0; i < n; i++) {
                triangle[i+count1][x] = num++;
            }
            n--;
            count1+=2;
            x++;
            for (int i = 0; i < n; i++) {
                triangle[y][i+count2] = num++;
            }
            n--;
            y--;
            count2++;
            for (int i = 0; i < n; i++) {
                triangle[y-i][n-i+x-1] = num++;
            }
            n--;

        }
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j <= i; j++) {
                a.add(triangle[i][j]);
            }
        }
        int[] answer = a.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
