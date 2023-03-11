package com.ll.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class pr {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        Arrays.sort(numbers);
        int [] reversed = IntStream.range(0, numbers.length)
                .map(i -> numbers[numbers.length -i -1])
                .toArray();
        int answer =  reversed[0] * reversed[1];
    }
}
