package com.ll.boj.bfs.p13913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static final int[] dx = new int[]{0, -1, 1};
    static int k;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] field = new int[100001][2];
        for (int i = 0; i <= 100000; i++) {
            Arrays.fill(field[i], -1);
        }
        br.close();

        bfs(field);
        String s = getList(field);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(field[k][0]));
        bw.newLine();
        bw.write(s);
        bw.flush();
        bw.close();
    }

    private static String getList(int[][] field) {
        int iter = k;
        StringBuilder sb = new StringBuilder();
        while (iter != n) {
            sb.insert(0, iter);
            sb.insert(0, ' ');
            iter = field[iter][1];
        }
        sb.insert(0, n);
        return sb.toString();
    }

    private static void bfs(int[][] field) {

        Queue<Integer> que = new LinkedList<>();
        field[n][0] = 0;
        que.add(n);
        while (!que.isEmpty()) {
            int num = que.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = num * 2;
                } else {
                    nx = num + dx[i];
                }
                if (nx < 0 || nx > 100000) continue;
                if (field[nx][0] != -1) continue;

                field[nx][1] = num;
                field[nx][0] = field[num][0] + 1;

                if (nx == k) {
                    return;
                }
                if(nx!=0) que.add(nx);
            }
        }
    }
}