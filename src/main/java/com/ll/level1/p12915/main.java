package com.ll.level1.p12915;

import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"abce", "abcd", "cdx"},2);
    }
}
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Comparator<String> c = (o1, o2) -> {
            if(o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        };
        Arrays.sort(strings, c);
        System.out.println(Arrays.toString(strings));
        return strings;
    }
}