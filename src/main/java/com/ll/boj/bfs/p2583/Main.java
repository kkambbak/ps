package com.ll.boj.bfs.p2583;
//https://www.acmicpc.net/problem/2583

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static final int[] dy = new int[] {0, 0, -1, 1};
	static final int[] dx = new int[] {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[m][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int l = y1; l < y2; l++) {
					arr[l][j] = 1;
				}
			}
		}
		int count = 0;
		List<Integer> li = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 0){
					int[] start = new int[] {i, j};
					arr[i][j] = 2;
					int cnt = bfs(n, m, arr, start);
					li.add(cnt);
					count++;
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(count));
		bw.newLine();
		bw.write(li.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
		bw.flush();
		bw.close();
	}

	private static int bfs(int n, int m, int[][] arr, int[] start) {
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		int x = 0;
		int y = 0;
		int cnt = 1;
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			y = poll[0];
			x = poll[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if(arr[ny][nx]==1 || arr[ny][nx]==2)
					continue;
				arr[ny][nx]=2;
				cnt++;
				que.add(new int[] {ny, nx});
			}
		}
		return cnt;
	}
}