package com.ll.boj.bfs.p6593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dz = new int[] {0, 0, 0, 0, -1, 1};
	static final int[] dy = new int[] { 0, 0, -1, 1, 0, 0};
	static final int[] dx = new int[] {-1, 1, 0, 0, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		while (!s.strip().equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][][] building = new int[l][r][c];

			int[] start = new int[0];
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					s = br.readLine();
					for (int k = 0; k < c; k++) {
						switch (s.charAt(k)) {
							case 'S' -> {
								building[i][j][k] = 1;
								start = new int[] {i, j, k, 0};
							}
							case '.' -> building[i][j][k] = 0;
							case '#' -> building[i][j][k] = -1;
							case 'E' -> building[i][j][k] = -2;
						}

					}
				}
				br.readLine();
			}

			//풀이
			int n = bfs(building, l, r, c, start);
			if (n == -1) {
				bw.write("Trapped!");
			} else {
				bw.write("Escaped in " + n + " minute(s).");
			}
			bw.newLine();

			s = br.readLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs(int[][][] building, int l, int r, int c, int[] start) {
		boolean[][][] visited = new boolean[l][r][c];
		Queue<int[]> que = new LinkedList<>();
		que.add(start);

		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int z = poll[0];
			int y = poll[1];
			int x = poll[2];

			for (int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c) continue;
				if(building[nz][ny][nx] == -1 || visited[nz][ny][nx]) continue;
				if(building[nz][ny][nx] == -2){
					return poll[3] + 1;
				}
				visited[nz][ny][nx] = true;
				que.add(new int[]{nz, ny, nx, poll[3] + 1});
			}
		}

		return -1;
	}
}
