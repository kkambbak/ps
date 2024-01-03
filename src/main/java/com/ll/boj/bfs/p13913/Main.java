package com.ll.boj.bfs.p13913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
    static final int[] dx = new int[]{0, -1, 1};
    static int k;
    static int n;

    static Deque<Integer> stack = new ArrayDeque<>();

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


        if(k < n){
            field[k][0] = n - k;
            while(k!=n){
                stack.offer(n);
                n--;
            }
            stack.offer(n);

        } else{
            bfs(field);
            push(field);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(' ');
        }
        String s = sb.toString();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(field[k][0]));
        bw.newLine();
        bw.write(s);
        bw.flush();
        bw.close();
    }

    private static void push(int[][] field) {
        int iter = k;
        while (iter != n) {
            stack.push(iter);
            iter = field[iter][1];
        }
        stack.push(n);
    }

    private static void bfs(int[][] field) {

        Queue<Integer> que = new LinkedList<>();
        field[n][0] = 0;
        que.add(n);
        while (!que.isEmpty()) {
            int num = que.poll();
            for (int i = 0; i < 3; i++) {

                int nx = (i == 0) ? num * 2 : num + dx[i];
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