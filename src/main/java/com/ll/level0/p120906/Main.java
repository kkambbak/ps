package com.ll.level0.p120906;

public class Main {
}
class Solution{

    public int solution(int n) {
        String nStr = n + "";
        int sum = 0;
        for (int i = 0; i < nStr.length(); i++) {
            // "안녕하".charAt(1) == '안'
            char c = nStr.charAt(i);

            // '1' (49) 이므로 바꿔줌
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    public int solutionV1(int n){
        return (n+"") // 123 -> "123"
                .chars()  // intStream[49,50,51]
                .map(e-> Character.getNumericValue(e)) //intStream[49,50,51] -> intStream[1,2,3]
                .sum(); // intStream[1,2,3] -> 6
    }

    public int solutionV2(int n){
        return (n+"") // 123 -> "123"
                .chars()  // intStream[49,50,51]
                .map(Character::getNumericValue) //intStream[49,50,51] -> intStream[1,2,3]
                .sum(); // intStream[1,2,3] -> 6
    }
}
