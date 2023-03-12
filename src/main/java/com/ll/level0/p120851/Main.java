package com.ll.level0.p120851;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("aAb1B2cC34oOp"));
    }

}
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char [] chars = my_string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int getNumVal = Character.getNumericValue(chars[i]);
            if (getNumVal < 10)
                answer += getNumVal;
        }
        return answer;
    }
}

class SolutionV2 {
    public int solution(String my_string) {
        int answer = 0;
        String str = my_string.replaceAll("[^0-9]","");
        for (int i : str.toCharArray()) {
            answer += Character.getNumericValue(i);
        }
        return answer;
    }
}