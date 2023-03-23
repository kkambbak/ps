package com.ll.level0.p120907;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String[] quiz = {"10000 - -10000 = 20000", "5 - 6 = -1"};


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < quiz.length; i++) {
            String[] equation = quiz[i].split("=");
            System.out.println(Arrays.toString(equation));


            String s;
            if (equation[0].contains("- -"))
                s = equation[0].replace("- -", "+ ");
            else s = equation[0].replace("- ", "+ -");

            String[] nums = s.split("\\+");
            System.out.println(Arrays.toString(nums));

            if(Integer.parseInt(nums[0].trim())+Integer.parseInt(nums[1].trim()) == Integer.parseInt(equation[1].trim()) )
                sb.append("O");
            else sb.append("X");
        }
        String[] answer = sb.toString().split("");
        System.out.println(sb.toString());
    }
}

class Solution{
    public String[] solution(String[] quiz) {
        for(int i=0; i<quiz.length; i++){
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
            quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
        }
        return quiz;
    }
}