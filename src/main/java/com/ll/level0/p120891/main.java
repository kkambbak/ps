package com.ll.level0.p120891;

import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        new Solution().solution(294032);
    }
}

class Solution {
    public int solution(int order) {
        String s = String.valueOf(order);
        s = s.replaceAll( "[0 1 2 4 5 7 8]" , "");
        return s.length();
    }
}