package com.ll.boj.bfs.p1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = new int[] {0, 0, -1, 1};
	static final int[] dy = new int[] {-1, 1, 0, 0};
	static final int[] knightX = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
	static final int[] knightY = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
	static int k;
	static int w;
	static int h;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		int[][] field = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		int bfs = bfs(field);
		if (h == 1 && w == 1 && field[0][0] == 0)
			bfs = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(bfs));
		bw.flush();
		bw.close();
	}

	private static boolean OOB(int y, int x) {
		return y < 0 || x < 0 || y >= h || x >= w;
	}

	private static int bfs(int[][] field) {
		int[][][] visited = new int[k + 1][h][w];

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0, 0, 0});
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int y = poll[0];
			int x = poll[1];
			int cnt = poll[2];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (OOB(ny, nx))
					continue;
				if (field[ny][nx] == 1)
					continue;
				if (visited[cnt][ny][nx] != 0)
					continue;
				if (ny == h - 1 && nx == w - 1) {
					visited[cnt][ny][nx] = visited[cnt][y][x] + 1;
					return visited[cnt][ny][nx];
				}
				visited[cnt][ny][nx] = visited[cnt][y][x] + 1;
				que.add(new int[] {ny, nx, cnt});
			}
			if (cnt < k) {
				for (int i = 0; i < 8; i++) {
					int ny = y + knightY[i];
					int nx = x + knightX[i];
					if (OOB(ny, nx))
						continue;
					if (field[ny][nx] == 1)
						continue;
					if (visited[cnt + 1][ny][nx] != 0)
						continue;
					if (ny == h - 1 && nx == w - 1) {
						visited[cnt + 1][ny][nx] = visited[cnt][y][x] + 1;
						return visited[cnt + 1][ny][nx];
					}
					visited[cnt + 1][ny][nx] = visited[cnt][y][x] + 1;
					que.add(new int[] {ny, nx, cnt + 1});
				}
			}
		}
		return -1;
	}
}
