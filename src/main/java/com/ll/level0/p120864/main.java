package com.ll.level0.p120864;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        new Solution().solution("abd8sf9sdf17sd");
    }
}

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String s = my_string.replaceAll("[^0-9]", "@").trim();
        String[] stringArr = s.split("@");
        for(String num : stringArr){
            if(!num.equals(""))
                answer+= Integer.parseInt(num);
        }
        return answer;
    }
}