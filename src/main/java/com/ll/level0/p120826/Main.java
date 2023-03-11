package com.ll.level0.p120826;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("BABCdeB", "B"));
    }
}
class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replaceAll(letter, "");
        return answer;
    }
}
