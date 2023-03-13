package com.ll.level0.p120895;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p120895 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("hello",1,3));
    }
}
class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        char temp = my_string.charAt(num1);
        sb.insert(num1, my_string.substring(num2, num2 + 1));
        sb.delete(num1+1, num1 + 2);
        sb.insert(num2, temp);
        sb.delete(num2+1, num2 + 2);
        answer= sb.toString();
        return answer;
    }
}
class SolutionV2 {
    public String solution(String myString, int num1, int num2) {
        List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());

        Collections.swap(list, num1, num2);
        return String.join("", list);
    }
}