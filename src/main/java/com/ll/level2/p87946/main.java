package com.ll.level2.p87946;

import java.util.*;

public class main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static boolean[] check;
    private static int resultX;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        check = new boolean[dungeons.length];
        tour(k,dungeons,0);
        answer = resultX;
        return answer;
    }

    void tour(int k, int[][] dungeons, int count) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!check[i] && k >= dungeons[i][0]) {
                check[i] = true;
                tour(k-dungeons[i][1], dungeons, count+1);
                check[i] = false;
            }
            resultX = Math.max(count,resultX);
        }
    }
}
