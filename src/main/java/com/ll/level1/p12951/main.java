package com.ll.level1.p12951;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        String s = "3people  unFollowed me";
        s = s.toLowerCase();
        String[] split = s.split(" ");

        String[] newS = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            if(!split[i].equals(""))
                newS[i] = split[i].substring(0,1).toUpperCase()+ split[i].substring(1,split[i].length());
            else
                newS[i] = "";
        }

        //String answer = String.join(" ", newS);
        String answer= Arrays.stream(newS).collect(Collectors.joining(" ")).toString();
        System.out.println(answer+"end");
    }
}
