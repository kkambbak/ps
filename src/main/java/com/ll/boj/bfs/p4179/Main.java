package com.ll.boj.bfs.p4179;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dy = new int[] {0, 0, -1, 1};
	static final int[] dx = new int[] {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] arr = new int[r][c];
		int[] start = new int[0];
		List<int[]> fire = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				switch (s.charAt(j)){
					case '#' -> arr[i][j] = -2;
					case '.' -> arr[i][j] = -1;
					case 'J' -> {arr[i][j] = 0; start = new int[] {i, j};}
					case 'F' -> {arr[i][j] = 0; fire.add(new int[] {i, j});}
				}
			}
		}
		br.close();

		new Main().solution(r, c, arr, start, fire);
	}

	private int solution(int r, int c, int[][] arr, int[] start, List<int[]> fire) throws Exception {

		int answer = 0;

		int[][] fires = new int[r][c];
		for (int i = 0; i < r; i++) {
			fires[i] = Arrays.copyOf(arr[i], c);
		}
		bfs1(r, c, fires, fire);
		answer = bfs2(r, c, arr, start, fires);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if (answer == -1)
			bw.write("IMPOSSIBLE");
		else
			bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		return 0;
	}

	private void bfs1(int r, int c, int[][] arr, List<int[]> fire) {
		Queue<int[]> que = new LinkedList<>(fire);

		int ny = 0;
		int nx = 0;

		while (!que.isEmpty()) {
			int[] p = que.poll();
			int y = p[0];
			int x = p[1];

			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (nx >= 0 && nx < c && ny >= 0 && ny < r && arr[ny][nx] != -2) {
					if (arr[ny][nx] == -1) {
						arr[ny][nx] = arr[y][x] + 1;
						que.add(new int[] {ny, nx});
					}
				}
			}
		}
	}

	private int bfs2(int r, int c, int[][] arr, int[] start, int[][] fires) {
		Queue<int[]> que = new LinkedList<>();
		que.add(start);

		int ny = 0;
		int nx = 0;

		while (!que.isEmpty()) {
			int[] p = que.poll();
			int y = p[0];
			int x = p[1];
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (nx < 0 || nx >= c || ny < 0 || ny >= r) {
					return arr[y][x] + 1;
				}
				if (nx >= 0 && nx < c && ny >= 0 && ny < r && arr[ny][nx] != -2) {
					if (arr[ny][nx] == -1 && (arr[y][x] + 1 < fires[ny][nx] || fires[ny][nx] == -1)) {
						arr[ny][nx] = arr[y][x] + 1;
						que.add(new int[] {ny, nx});
					}
				}
			}
		}
		return -1;
	}

	private void show(int[][] arr){
		System.out.println("---------------------------");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}