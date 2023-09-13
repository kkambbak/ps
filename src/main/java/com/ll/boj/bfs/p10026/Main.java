package com.ll.boj.bfs.p10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int[] dy = new int[] {0, 0, -1, 1};
	static final int[] dx = new int[] {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		boolean[][] check1 = new boolean[n][n];
		boolean[][] check2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				switch (s.charAt(j)) {
					case 'R' -> arr[i][j] = 1;
					case 'G' -> arr[i][j] = 2;
					case 'B' -> arr[i][j] = 3;
				}
			}
		}

		br.close();

		new Main().solution(n, arr, check1, check2);
	}

	private int solution(int n, int[][] arr, boolean[][] check1, boolean[][] check2) throws Exception {

		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check1[i][j]) {
					bfs(arr, n, new int[] {i, j}, check1);
					cnt1++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check2[i][j]) {
					bfs2(arr, n, new int[] {i, j}, check2);
					cnt2++;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(cnt1);
		sb.append(' ');
		sb.append(cnt2);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		return 0;
	}

	private void bfs(int[][] arr, int n, int[] start, boolean[][] check1) {
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		int x = 0;
		int y = 0;
		check1[start[0]][start[1]] = true;
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			y = poll[0];
			x = poll[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (check1[ny][nx])
					continue;
				if (arr[ny][nx] != arr[y][x])
					continue;
				check1[ny][nx] = true;
				que.add(new int[] {ny, nx});
			}
		}
	}

	private void bfs2(int[][] arr, int n, int[] start, boolean[][] check2) {
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		int x = 0;
		int y = 0;
		check2[start[0]][start[1]] = true;
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			y = poll[0];
			x = poll[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (check2[ny][nx])
					continue;
				if (arr[y][x] == 3 && (arr[ny][nx] == 1 || arr[ny][nx] == 2))
					continue;
				if ((arr[y][x] == 1 || arr[y][x] == 2) && arr[ny][nx] == 3)
					continue;
				check2[ny][nx] = true;
				que.add(new int[] {ny, nx});
			}
		}
	}

	private void show(int[][] arr) {
		System.out.println("---------------------------");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}