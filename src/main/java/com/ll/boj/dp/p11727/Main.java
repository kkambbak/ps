package com.ll.boj.dp.p11727;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        new Main().solution(n);
    }

    private void solution(int n) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(3);

        for (int i = 2; i < n; i++) {
            li.add((li.get(i - 2) * 2 + li.get(i - 1)) % 10007);
        }

        answer = li.get(n - 1);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
