package com.ll.level0;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {
    public static void main(String[] args) {
        String[] seoul = new String[]{"Jane", "Kim"};

        String answer = "";
        int idx = Arrays.stream(seoul).toList().indexOf("Kim");
        answer = "김서방은 "+idx+"에 있다.";
        System.out.println(answer);
    }
}