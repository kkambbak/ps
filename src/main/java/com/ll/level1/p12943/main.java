package com.ll.level1.p12943;

//콜라츠 추측
public class main {
}

class Solution {
    public int solution(int num) {
        int count = 0;
        long n = (long) num;
        if (n == 1) return 0;
        while (count++ < 500){
            if(n%2 == 0)
                n /= 2;
            else
                n = n*3 + 1;

            if(n == 1) return count;
        }
        return -1;
    }
}
