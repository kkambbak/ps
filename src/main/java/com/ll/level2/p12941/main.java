package com.ll.level2.p12941;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {1,2,3};

        Arrays.sort(A);
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < B.length/2; i++){
            int temp = B[i];
            B[i] = B[B.length-1-i];
            B[B.length-1-i] = temp;
        }
        for(int i = 0; i < A.length; i++){
            answer +=A[i] * B[i];
        }
        //return answer;
    }
}
