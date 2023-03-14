package com.ll.level0.p120888;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class main {
    public static void main(String[] args) {
        new SolutionV3().solution("We are the world");
    }
}
class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        HashSet set = new HashSet();
        for (char c: my_string.toCharArray()
             ) {
            if(!set.contains(c)) sb.append(c);
            set.add(c);
        }
        System.out.println(sb.toString());
        return answer;
    }
}
class SolutionV2 {
    public String solution(String my_string) {
        String[] answer = my_string.split("");
        StringBuilder sb = new StringBuilder();
        LinkedHashSet set = new LinkedHashSet(Arrays.asList(answer));
        System.out.println(String.join("",set));
        return String.join("",set);

    }
}
class SolutionV3{
    public String solution(String my_string) {
        my_string = my_string.replaceAll("[^a-z]", "");
        System.out.println(my_string);
        return my_string;
    }
}