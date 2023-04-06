package com.ll.level0.p120921;

import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        String A = "hello";
        String B = "ohell";
        String temp;
        System.out.println(temp= B.repeat(2));
        //return temp.indexOf(A);
    }
}

class Solution {
    public int solution(String A, String B) {
        int len = A.length();
        if (A.equals(B)) return 0;
        for (int i = 0; i < len; i++) {
            A = A.substring(len-1,len) + A.substring(0,len-1);
            if(A.equals(B)) return i+1;
        }
        return -1;
    }
}
