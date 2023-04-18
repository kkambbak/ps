package com.ll.level2.p68936;

import java.util.Arrays;
public class main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        int len = arr.length-1;
        return quad(arr,0,len,0,len);
    }
    //상태를 나타내는 함수
    int[] quad(int[][] arr, int xStart, int xEnd, int yStart, int yEnd){
        //종료조건
        if(xStart==xEnd && yStart==yEnd){
            if(arr[xStart][yStart] == 1){
                return new int[]{0,1};
            }
            if(arr[xStart][yStart] == 0){
                return new int[]{1,0};
            }
        }
        int halfLen = (xEnd-xStart+1)/2;
        //점화식
        int[] num1 = quad(arr, xStart, xEnd-halfLen, yStart, yEnd-halfLen);
        int[] num2 = quad(arr, xStart+halfLen, xEnd, yStart, yEnd-halfLen);
        int[] num3 = quad(arr, xStart, xEnd-halfLen, yStart+halfLen, yEnd);
        int[] num4 = quad(arr, xStart+halfLen, xEnd, yStart+halfLen, yEnd);
        return merge(num1,num2,num3,num4);
    }
    int[] merge(int[] i1, int[] i2, int[] i3, int[] i4){
        int[] arr0 = new int[]{1,0};
        int[] arr1 = new int[]{0,1};
        if(Arrays.equals(i1, arr0) && Arrays.equals(i2, arr0) && Arrays.equals(i3, arr0) && Arrays.equals(i4, arr0)){
            return arr0;
        }
        else if(Arrays.equals(i1, arr1) && Arrays.equals(i2, arr1) && Arrays.equals(i3, arr1) && Arrays.equals(i4, arr1)){
            return arr1;
        }
        else {
            return new int[] {i1[0]+i2[0]+i3[0]+i4[0],i1[1]+i2[1]+i3[1]+i4[1]};
        }
    }
}