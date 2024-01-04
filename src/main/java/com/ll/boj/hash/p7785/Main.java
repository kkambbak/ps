package com.ll.boj.hash.p7785;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[1].equals("enter")) {
                set.add(s[0]);
            }
            else {
                set.remove(s[0]);
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
