package com.ll.level0.p120892;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("dfjardstddetckdaccccdegk",4));
    }
}
class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char [] arrCipher = cipher.toCharArray();
        for (int i = code-1; i < arrCipher.length; i+=code) {
            sb.append(arrCipher[i]);
        }
        answer = String.valueOf(sb);
        return answer;
    }
}