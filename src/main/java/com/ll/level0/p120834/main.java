package com.ll.level0.p120834;

public class main {
    public static void main(String[] args) {

        int c = 100;

        System.out.println(Character.toChars(97));
        System.out.println((char)c);
        System.out.println(new Solution().solution(100));
    }
}
class Solution {
    public String solution(int age) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(age);
        for (int i = 0; i < s.length(); i++) {
            sb.append((char)(Character.getNumericValue(s.charAt(i))+97));
        }
        return answer = sb.toString();
    }
}