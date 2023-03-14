package com.ll.level0.p120904;

public class main {
    public static void main(String[] args) {
        new Solution().solution(29183, 1);
    }
}
class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        int len = (num+"").length();
        for (int i = 0; i < len; i++) {
            if(num%10 == k)
                answer = len-i;
            num/=10;
        }
        System.out.println(answer);
        return answer;
    }
}
class SolutionV2 {
    public int solution(int num, int k) {
        return ("-" + num).indexOf(String.valueOf(k));
    }
}

