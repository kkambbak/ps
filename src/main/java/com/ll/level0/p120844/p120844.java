package com.ll.level0.p120844;

import java.util.ArrayList;
import java.util.Arrays;

public class p120844 {
    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3},"right");
    }
}
class Solution {
    public int[] solution(int[] numbers, String direction) {

        int len = numbers.length;
        int[] answer = new int[len];
        if(direction.equals("right")){
            for (int i = 1; i < len; i++) {
                answer[i] = numbers[i-1];
            }
            answer[0] = numbers[len-1];
        }
        else{
            for (int i = 0; i < len-1; i++) {
                answer[i] = numbers[i+1];
            }
            answer[len-1] = numbers[0];
        }

        return answer;
    }
}
