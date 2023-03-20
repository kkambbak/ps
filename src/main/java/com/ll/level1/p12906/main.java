package com.ll.level1.p12906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        ArrayList<Integer> al = new ArrayList<>();
        al.add(arr[0]);
        for (int i = 1; i < arr.length ; i++){
            if(arr[i]==arr[i-1]) continue;
            al.add(arr[i]);
        }
        //array로 변환

        System.out.println(al.toString());

    }
}
