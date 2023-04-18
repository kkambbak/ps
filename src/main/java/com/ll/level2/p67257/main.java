package com.ll.level2.p67257;

import java.util.*;

public class main {
    public static void main(String[] args) {
        new Solution().solution("100-200*300-500+20");
    }
}

class Solution {
    public long solution(String expression) {
        long answer = 0;

        //분리
        StringTokenizer st = new StringTokenizer(expression, "*-+", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        long max = 0;
        for (String[] priority : priorities) {
            long abs = Math.abs(calc(new ArrayList<>(tokens), priority));
            if (abs > max)
                max = abs;
        }

        System.out.println(max);
        return max;
    }

    private static final String[][] priorities = {
            "*-+".split(""),
            "*+-".split(""),
            "-*+".split(""),
            "-+*".split(""),
            "+*-".split(""),
            "+-*".split("")
    };

    private long calculate(long num1, long num2, String op) {
        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> 0;
        };
    }

    private long calc(List<String> tokens, String[] priority) {
        for (String op : priority) {
            for (int i = 0; i < tokens.size(); i++) {
                if (Objects.equals(op, tokens.get(i))) {
                    long num1 = Long.parseLong(tokens.get(i - 1));
                    long num2 = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(num1, num2, op);

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);

                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
}