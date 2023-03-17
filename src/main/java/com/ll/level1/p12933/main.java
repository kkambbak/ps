package com.ll.level1.p12933;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        long n = 123914;
        String[] sArr =  (n + "").split("");
        String s = Arrays.stream(sArr).sorted(Comparator.reverseOrder()).collect(Collectors.joining()).toString();
        long answer = Long.parseLong(s);
    }
}
