package com.ll.boj.bfs.p2146;

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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[][] field = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		findIslands(field);
		int answer = makeBridge(field);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	private static int makeBridge(int[][] field) {

		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(field[i][j] != 0) {
					bfs2(copy(field), new int[] {i, j}, li);
				}
			}
		}
		return li.stream().min(Integer::compareTo).get();
	}

	private static int[][] copy(int[][] field) {
		int[][] newField = new int[n][n];
		for (int i = 0; i < n; i++) {
			newField[i] = Arrays.copyOf(field[i], n);
		}
		return newField;
	}

	private static void bfs2(int[][] field, int[] start, List<Integer> li) {
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> que = new LinkedList<>();
		que.add(start);

		visited[start[0]][start[1]] = true;
		final int islandNum = field[start[0]][start[1]];
		field[start[0]][start[1]] = 1;
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int y = poll[0];
			int x = poll[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >=n) continue;
				if(visited[ny][nx]) continue;
				if(field[ny][nx] > 0 || field[ny][nx] == islandNum) continue;
				if(field[ny][nx] < 0 && field[ny][nx] != islandNum){
					li.add(field[y][x]-1);
					return;
				}

				visited[ny][nx] = true;
				que.add(new int[] {ny, nx});
				field[ny][nx] = field[y][x] + 1;
			}
		}
	}

	private static void findIslands(int[][] field) {
		boolean[][] visited = new boolean[n][n];
		int num = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j] && field[i][j] == 1){
					visited[i][j] = true;
					bfs(field, visited, new int[]{i,j}, num--);
				}
			}
		}
	}

	private static void bfs(int[][] field, boolean[][] visited, int[] start, int num) {
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		field[start[0]][start[1]] = num;
		while (!que.isEmpty()) {
			int[] poll = que.poll();
			for (int i = 0; i < 4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >=n) continue;
				if(field[ny][nx] == 0) continue;
				if(visited[ny][nx]) continue;

				visited[ny][nx] = true;
				que.add(new int[] {ny, nx});
				field[ny][nx] = num;
			}
		}
	}
}

/* O(n^4) 풀이법임.
풀이를 개선해보자.
#1 같은 섬에 속한 육지는 동시에 BFS를 돌린다.
큐에 start만 넣을게아니라, 섬에 속하는 모든 (i,j)좌표를 큐에 넣고 bfs를 돌린다.

#2 큐에 (y,x) 형식이 아니라 (y,x,dist) 형식으로 넣는다.
 */