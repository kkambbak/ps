package com.ll.level1.p81301;

public class main {
    public static void main(String[] args) {
        new Solution().solution("one4seveneight");
    }
}

class Solution {
    public long solution(String s) {
        long answer = 0;
        s = s.replaceAll("one", "1");
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");

        answer = Long.parseLong(s);
        return answer;
    }
}