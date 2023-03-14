package com.ll.level0.p120896;

import java.util.*;

public class main {
    public static void main(String[] args) {
        new Solution().solution("ahellow");
    }
}

class Solution {
    public String solution(String s) {
        String answer = "";
        HashSet set = new HashSet();
        HashSet answerSet = new HashSet();
        char[] charArray = s.toCharArray();
        for (char c: charArray
             ) {
            if(!set.contains(c)) {
                set.add(c);
                answerSet.add(c);
            }
            else if (answerSet.contains(c)){
                answerSet.remove(c);
            }
        }
        Object[] answerArray = answerSet.toArray();
        Arrays.sort(answerArray);
        answer = Arrays.toString(answerArray);
        answer = answer.replaceAll("[^a-z]","").trim();
        System.out.println(answer);
        return answer;
    }
}

class SolutionV2 {
    public String solution(String s) {
        String answer = "";

        int[] alphabet = new int[26];
        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            alphabet[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
                if (alphabet[i] == 1) sb.append(i+'a');
        }
        return sb.toString();
    }
}