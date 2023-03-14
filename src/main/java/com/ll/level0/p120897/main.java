package com.ll.level0.p120897;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        new SolutionV3().solution(10);
    }
}

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        answer = IntStream.range(1,n).filter(v -> n%v ==0).toArray();
        return answer;
    }
}
class SolutionV3 {
    public int solution(int n) {
        int answer = 0;
        if(n <4) return n;
        for(int i = 4 ; i < n ; i++){
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}