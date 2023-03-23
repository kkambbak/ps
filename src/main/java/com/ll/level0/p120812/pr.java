package com.ll.level0.p120812;

import java.util.*;

public class pr {
    public static void main(String[] args) {

    }

}

class Solution{
   int solution(){
        int[] array = {1, 2, 3, 3, 3,3,3, 4,4,4};
        int answer = 0;
        int[] counts = new int[1000];
        Arrays.fill(counts, 0);
        for(int i = 0 ; i< array.length; i++){
            counts[array[i]]++;
        }
        int max = Arrays.stream(counts).max().getAsInt();
        boolean check=true;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] == max){
                if(check){
                    check = false;
                    answer = i;
                }
                else return -1;
            }
        }
        return answer;
    }
}