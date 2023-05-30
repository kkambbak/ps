package com.ll.level0;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {

    public static void main(String[] args) {
        List<Integer> li = List.of(100,101,102,103,103,104,145,146,150,151,152,200,201,300);
        ArrayList<Integer> list = new ArrayList<>(li);

        int num = binarySearch(list, 149);
        System.out.println(num);

        String s = "sdf";
        String s2 = s;

        s2+="ddd";
        System.out.println(s);
    }
    private static int binarySearch(ArrayList<Integer> list, int target){
        int start = 0;
        int end = list.size() - 1;

        while(end >= start){
            int mid = (start + end) / 2;
            if(list.get(mid) < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
}