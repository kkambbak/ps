package com.ll.level2.p42860;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        new Solution().solution("JEROEN");
    }
}
class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        char[] nameArr = name.toCharArray();

        return 0;

    }

    private int upDownCount(char c){
        int count = 0;
        if (c - 'A' > 13){
            count += ('Z' - c) + 1;
        }
        else{
            count += c - 'A';
        }
        return count;
    }
}