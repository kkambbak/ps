package com.ll.level1.p68935;


import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        new Solution().solution(9);
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        int maxNum = 0;
        while (n-Math.pow(3,maxNum)>=0){maxNum++;}
        StringBuilder sb = new StringBuilder();
        for(int i = (int)maxNum-1; i >=0; i--){
            int num = (int)Math.pow(3,i);
            sb.append((n/num));
            n%=num;
        }
        String s = sb.toString();
        char[] c = s.toCharArray();
        int idx = 0;
        for(int i =0; i< s.length(); i++){
            System.out.println(c[i]);
            answer += (c[i]-'0') * Math.pow(3,i);
            System.out.println(answer);
        }
        return answer;
    }
}