package com.ll.level0;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class pr {
    public static void main(String[] args) {

        boolean answer = true;
        String s = "pPoooyY";

        s=s.replaceAll("[^p,y]", "");
        int pCount = 0;
        int yCount = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (i == 'p') pCount++;
            if (i == 'y') yCount++;
        }
        //return pCount==yCount ? true : false;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(s);

        System.out.println(answer);
    }
}
class Solution{
    boolean Solution(){
        String s = "pPoooyY";
        s.toUpperCase();
        return s.chars().filter(e->'P' == e).count() == s.chars().filter(e->'Y' == e).count();
    }
}
