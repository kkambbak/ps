package com.ll.boj.bfs.p2468;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dy = new int[] {0, 0, -1, 1};
	static final int[] dx = new int[] {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int maxH = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, arr[i][j]);
			}
		}

		int maxCnt = 0;
		for (int i = 0; i < maxH; i++) {
			boolean[][] visited = new boolean[n][n];
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (!visited[j][k] && arr[j][k] > i) {
						bfs(arr, visited, new int[] {j, k}, i);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(cnt, maxCnt);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(maxCnt));
		bw.flush();
		bw.close();
	}

	private static void bfs(int[][] arr, boolean[][] visited, int[] start, int h) {

		Queue<int[]> que = new LinkedList<>();
		que.add(start);

		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int y = poll[0];
			int x = poll[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= arr.length || nx < 0 || nx >= arr.length)
					continue;
				if (visited[ny][nx] || arr[ny][nx] <= h)
					continue;
				visited[ny][nx] = true;
				que.add(new int[] {ny, nx});
			}
		}
	}
}
