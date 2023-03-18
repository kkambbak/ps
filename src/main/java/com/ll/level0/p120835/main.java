package com.ll.level0.p120835;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        int[] emergency = {3, 76, 24};

        int len = emergency.length;
        int[] answer = new int[len];
        int[] arr = emergency.clone();
        Arrays.sort(emergency);
        for (int i = 0; i < len; i++)
            answer[i] = len - Arrays.binarySearch(emergency,arr[i]);


        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int[] e) {
        return Arrays.stream(e).map(i -> Arrays.stream(e).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i) + 1).toArray();
    }
}
