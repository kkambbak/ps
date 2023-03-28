package com.ll.level0.p120878;

public class main {
    public static void main(String[] args) {

        int i = new Solution().solution(2, 1);
        System.out.println(i);
    }
}
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        boolean check = true;
        while(check){
            if(b==1){
                return 1;
            } else if(b%2 == 0){
                b/=2;
            } else if (b % 5 == 0) {
                b/=5;
            } else{
                return 2;
            }
        }
        return answer;
    }
}