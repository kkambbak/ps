package com.ll.level0.p120885;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        String bin1 = "1001";
        String bin2 = "1111";

        int i = Integer.parseInt(bin1, 2);
        int j = Integer.parseInt(bin2, 2);
        String answer = Integer.toBinaryString(i + j);

        String s = "zsdfsgZDSAQ";
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.reverse();
        System.out.println(charArr);

    }
}
