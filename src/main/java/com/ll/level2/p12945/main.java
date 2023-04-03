package com.ll.level2.p12945;

public class main {
}
class Solution {
    int[] fibArr;

    public int solution(int n) {
        int answer = 0;
        fibArr = new int[n+1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        answer = fib(n)%1234567;
        return answer;
    }
    int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(fibArr[n] == 0){
            fibArr[n] = (fib(n-2) %1234567)+(fib(n-1) %1234567);
        }
        return fibArr[n] ;
    }
}