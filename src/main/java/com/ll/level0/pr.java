package com.ll.level0;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {
    public static void main(String[] args) {
        String my_string = "3 + 4 + 6";
        my_string= my_string.replaceAll(" - ", " + -");
        String[] s = my_string.split(" \\+ ");
        int sum = Arrays.stream(s).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
        StringBuilder sb= new StringBuilder();
        sb.append("*");
        sb.append("*".repeat(3));
        int i = 1231;
        int x = Integer.reverse(i);
        System.out.println(x);


    }
}