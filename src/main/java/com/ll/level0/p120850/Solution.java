package com.ll.level0.p120850;

import java.util.Arrays;

public class Solution {
    public int[] solution(String my_string) {

        String newString = my_string.replaceAll("[^0-9]", "");
        int[] answer = new int[newString.length()];
        int i = 0;
        for (char c: newString.toCharArray()
             ) {
            answer[i] = Character.getNumericValue(c);
            i++;
        }
        Arrays.sort(answer);
        return answer;
    }
}

class SolutionV2 {
    public int[] solution(String myString) {
        return Arrays.stream(myString.replaceAll("[A-Z|a-z]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();
    }
}