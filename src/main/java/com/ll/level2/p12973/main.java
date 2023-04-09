package com.ll.level2.p12973;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        String s = "baabaa";
        char[] words = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char word: words
             ) {
            if(stack.isEmpty()) stack.push(word);
            else if(stack.peek().equals(word)){
                stack.pop();
            } else stack.push(word);
        }
        int answer = -1;
        if(stack.isEmpty()) answer =1;
        else answer = 0;
        //return answer;
    }
}
