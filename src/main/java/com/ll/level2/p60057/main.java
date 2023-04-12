package com.ll.level2.p60057;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        new Solution().solution(s);
    }
}

class Solution {

    public int solution(String s) {
        int answer = 0;

        int len = s.length();
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < len/2; i++) {
            //answer = checkRepeat2(s, i);
            System.out.println(answer);
            li.add(answer);
        }
        answer = li.stream().mapToInt(Integer::valueOf).min().getAsInt();

        System.out.println(answer);
        return answer;
    }


    /* 문제를 잘못이해해서 1시간 동안 만든 코드 ㅋㅋㅋㅋㅋㅋㅋ;;
    abcabcabcabcbbbccccd -> 4abc3b4cd 로 압축시킴 */
    String checkRepeat(int startNum, int endNum) {
        String s1 = "abcabcabcabcbbbccccd";
        if(startNum==endNum){
            return "";
        }
        int zipLen = 1;
        int repeatTime = 1;
        boolean checkSame = true;

        if (startNum + zipLen >= endNum) {
            return s1.substring(startNum, startNum + zipLen);
        }
        while (!s1.substring(startNum, startNum+zipLen).equals(s1.substring(startNum+zipLen, startNum + 2 * zipLen))) {
            if(startNum+zipLen >= endNum){
                return s1.substring(startNum, startNum + zipLen);
            }
            zipLen++;
        }

        int i = zipLen;
        while (checkSame) {
            if (!s1.substring(startNum, startNum+zipLen).equals(s1.substring(startNum+i, startNum+i + zipLen))) {
                checkSame = false;
            } else {
                repeatTime++;
                i+=zipLen;
            }
            if(startNum+i==endNum){
                checkSame = false;
            }
        }

        String frontString;
        if (repeatTime == 1)
            frontString = s1.substring(startNum, zipLen);
        else
            frontString = repeatTime + s1.substring(startNum, startNum+zipLen);

        String backString = checkRepeat(startNum+zipLen * repeatTime, endNum);

        return frontString+backString;
    }
}