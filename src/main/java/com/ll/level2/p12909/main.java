package com.ll.level2.p12909;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution());
    }
}
class Solution{

    boolean solution() {
        String s = "()(())";

        int idx =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==('(')){
                 idx++;
            }
            else if(s.charAt(i)==(')')&&idx==0){
                return false;
            } else idx--;
        }
        return idx==0;
    }
}