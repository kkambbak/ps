package com.ll.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {
    public static void main(String[] args) {
        String s = "1011011";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if(s.charAt(i)=='1')count++;

        }
        System.out.println(count);
        StringBuilder sb = new StringBuilder("hello");
    }
}