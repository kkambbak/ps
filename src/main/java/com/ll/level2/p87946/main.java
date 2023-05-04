package com.ll.level2.p87946;

import java.util.*;
public class main {
}

class Solution {
    private static int minNeedP;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int[] min = Arrays.stream(dungeons).min(Comparator.comparingInt(i -> i[0])).get();
        minNeedP = min[0];
        for(int i = 0; i< dungeons.length; i++){
            tour(k, dungeons, new boolean[dungeons.length], 0, 0, i);
        }
        answer= resultX;
        return answer;
    }
    private static int resultX;

    void tour(int k, int[][]dungeons, boolean[] checkDungeons,int count,int result,int num){
        //카운트
        if(k>=dungeons[num][0]){
            k-=dungeons[num][1];
            checkDungeons[num] = true;
            count+=1;
            result+=1;
        }


        //종료조건
        if (k< minNeedP || count==dungeons.length){
            resultX = Math.max(result, resultX);
            return;
        }

        //재귀 호출
        for(int i = 0; i<dungeons.length; i++){
            boolean[] newArr = Arrays.copyOf(checkDungeons, checkDungeons.length);
            if(!checkDungeons[i]){
                if(k>=dungeons[i][0])
                    tour(k, dungeons, newArr, count, result, i);
            }
        }
    }
}
