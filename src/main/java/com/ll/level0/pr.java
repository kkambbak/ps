package com.ll.level0;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {
    public static void main(String[] args) {
        List<Integer> l = List.of(1,2,3,4,4,4,5,6,7,8);

        l.stream().filter(i->i>4)
                .forEach(System.out::println);

        l.stream()
                .distinct()
                .forEach(System.out::println);



    }
}