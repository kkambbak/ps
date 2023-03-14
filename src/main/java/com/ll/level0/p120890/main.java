package com.ll.level0.p120890;

import java.util.*;
public class main {
    public static void main(String[] args) {
        new Solution().solution(new int[]{10, 11, 12},13);
    }
}

class Solution {
    public int solution(int[] array, int n) {
        int[] newArr = new int[array.length+1];
        int answer = 0;
        Arrays.sort(array);
        if (array[0]> n ) return array[0];
        if (array[array.length-1] < n) return array[array.length-1];

        for(int i = 0 ; i < array.length; i++)
            newArr[i] = array[i];
        newArr[array.length] = n;
        Arrays.sort(newArr);
        int idx = Arrays.binarySearch(newArr,n);

        if( n - newArr[idx-1] <= newArr[idx+1] - n){
            answer= newArr[idx-1];
        } else
            answer= newArr[idx+1];
        System.out.println(answer);
        return answer;
    }
}