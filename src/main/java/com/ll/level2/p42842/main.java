package com.ll.level2.p42842;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        List<Integer> li = IntStream.rangeClosed(1,yellow/2)
                .filter(i->yellow%i==0)
                .boxed().collect(Collectors.toList());

        for (int row: li
             ) {
            int col = yellow / row;
            if(brown == 2*(row+col) +4 ) {}//return new int[]{col+2, row+2};
        }
    }

}
