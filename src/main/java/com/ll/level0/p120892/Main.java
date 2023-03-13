package com.ll.level0.p120892;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
//Stream
class SolutionV2 {
    public String solution(String cipher, int code) {
        return IntStream.range(0, cipher.length())
                .filter(value -> value % code == code - 1)
                .mapToObj(c -> String.valueOf(cipher.charAt(c)))
                .collect(Collectors.joining());
    }
}