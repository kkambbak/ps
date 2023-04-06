package com.ll.level0.p120880;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;

public class main {
    public static void main(String[] args) {
        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;
        Comparator<Integer> cmp = (a,b) -> {
            int disA = Math.abs(a-n);
            int disB = Math.abs(b-n);

            if( disA == disB ) return b - a;
            else return disA-disB;
        };

        int[] answer = Arrays.stream(numlist)
                .boxed()
                .sorted(cmp)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(answer));
        //return answer;

    }
}
