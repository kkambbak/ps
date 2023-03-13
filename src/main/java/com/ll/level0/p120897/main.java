package com.ll.level0.p120897;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        new Solution().solution(29);
    }
}

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        answer = IntStream.range(1,n).filter(v -> n%v ==0).toArray();
        return answer;
    }
}
