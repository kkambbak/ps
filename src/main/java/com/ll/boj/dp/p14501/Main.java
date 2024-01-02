package com.ll.boj.dp.p14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> li = new ArrayList<>();
        int[] days = new int[n];
        int[] pays = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            days[i] = t;
            pays[i] = p;
            li.add(new int[]{t, p});
        }
        br.close();

        new Main().solution(n, days, pays);
    }

    private void solution(int n, int[] days, int[] pays) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        int[] memo = new int[n+1];

        for (int i = 0; i < n; i++) {
            int idx = i + days[i];
            if (idx <= n){
                if(i!=0) memo[i] = Math.max(memo[i], memo[i-1]);
                memo[idx] = Math.max(memo[idx], memo[i] + pays[i]);
            }
        }

        answer = Arrays.stream(memo).max().getAsInt();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
