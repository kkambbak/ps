package com.ll.level2.p70129;

public class main {
    public static void main(String[] args) {
        String s = "110010101001";

        int[] answer = new int[2];
        int len = s.length();
        int count = 0;
        int zeroCount = 0;
        int slen = 0;


        while(!s.equals("1")){
            // 0없애고 카운트
            len = s.length();
            s=s.replaceAll("[0]","");
            zeroCount += ( len-s.length() );

            // 이진변환
            len = s.length();
            s = "";
            while(len!=0){
                s = len%2 + s;
                len/=2;
            }
            // 회차++
            count++;
        }
        answer = new int[]{count, zeroCount};
        //return answer;
    }
}
