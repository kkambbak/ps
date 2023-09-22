package com.ll.boj.bfs.p2573;

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

	static final int[] dx = new int[] {0, 0, -1, 1};
	static final int[] dy = new int[] {-1, 1, 0, 0};
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] field = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		int t = 1;
		while (true) {
			Field melt = melt(field);
			if (check(melt.ice, melt.field)) {
				break;
			}
			field = melt.field;
			t++;
			if (melt.ice.isEmpty()) {
				t = 0;
				break;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(t));
		bw.flush();
		bw.close();
	}

	private static boolean check(List<int[]> ice, int[][] field) {
		boolean[][] visited = new boolean[n][m];
		int cnt = 0;
		for (int[] i : ice
		) {
			int y = i[0];
			int x = i[1];
			if (!visited[y][x] && field[y][x] != 0) {
				bfs(field, visited, new int[] {y, x});
				cnt++;
			}
		}
		return cnt > 1;
	}

	private static void bfs(int[][] field, boolean[][] visited, int[] start) {
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int y = poll[0];
			int x = poll[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (visited[ny][nx])
					continue;
				if (field[ny][nx] == 0)
					continue;
				visited[ny][nx] = true;
				que.add(new int[] {ny, nx});
			}
		}
	}

	private static Field melt(int[][] copy) {

		int[][] field = new int[n][m];
		List<int[]> ice = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 0)
					continue;
				int h = 0;
				for (int k = 0; k < 4; k++) {
					if (copy[i + dy[k]][j + dx[k]] == 0)
						h++;
				}
				field[i][j] = copy[i][j] - h;
				if (field[i][j] <= 0)
					field[i][j] = 0;
				else
					ice.add(new int[] {i, j});
			}
		}

		return new Field(ice, field);
	}

	static class Field {
		List<int[]> ice;
		int[][] field;

		public Field(List<int[]> ice, int[][] field) {
			this.ice = ice;
			this.field = field;
		}
	}

	static void print(int[][] board) {
		System.out.println("----------------------");
		for (int[] i : board) {
			System.out.println(Arrays.toString(i));
		}
	}
}