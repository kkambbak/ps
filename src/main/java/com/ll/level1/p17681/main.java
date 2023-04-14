package com.ll.level1.p17681;

public class main {
    public static void main(String[] args) {
        new Solution().solution(5,new int []{9, 20, 28, 18, 11},new int []{30, 1, 21, 17, 28});
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] sArr1 = new String[n];
        String[] sArr2 = new String[n];
        String[] sArrOr = new String[n];

        for (int i = 0; i < n; i++) {
            sArr1[i] = makeNLengthBinary(n, arr1[i]);
            sArr2[i] = makeNLengthBinary(n, arr2[i]);
            sArrOr[i] = binaryOrAndDecrypt(n, sArr1[i], sArr2[i]);
        }
        return sArrOr;
    }

    String makeNLengthBinary(int length, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(num%2);
            num/=2;
        }

        return sb.reverse().toString();
    }

    String binaryOrAndDecrypt(int n,String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char s = (s1.charAt(i) | s2.charAt(i) )=='1' ? '#':' ';
            sb.append(s);
        }
        return sb.toString();
    }
}