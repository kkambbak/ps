package com.ll.level1.p12935;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class main {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,3,5};
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = {};
        answer = Arrays.stream(arr).filter(v->v!=min).toArray();

        System.out.println(Arrays.toString(answer));

    }
}
