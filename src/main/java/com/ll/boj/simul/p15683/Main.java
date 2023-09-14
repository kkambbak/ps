package com.ll.boj.simul.p15683;

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
	static Queue<List<int[][]>> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		List<int[][]> start = new ArrayList<>();
		start.add(arr);
		que.add(start);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > 0 && arr[i][j] < 6) {
					List<int[][]> li = que.poll();
					switch (arr[i][j]) {
						case 1 -> que.add(c1(li, new int[] {i, j}));
						case 2 -> que.add(c2(li, new int[] {i, j}));
						case 3 -> que.add(c3(li, new int[] {i, j}));
						case 4 -> que.add(c4(li, new int[] {i, j}));
						case 5 -> que.add(c5(li, new int[] {i, j}));
					}
				}

			}
		}
		int answer = que.poll().stream().map(Main::count).min(Integer::compareTo).get();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	private static List<int[][]> c5(List<int[][]> li, int[] pos) {
		List<int[][]> newLi = new ArrayList<>();
		for (int[][] arr : li) {
			int[][] new1 = copy(arr);
			for (int i = 1; i <= 4; i++) {
				watch(new1, i, pos);
			}
			newLi.add(new1);
		}
		return newLi;
	}

	private static List<int[][]> c4(List<int[][]> li, int[] pos) {
		List<int[][]> newLi = new ArrayList<>();
		for (int[][] arr : li) {
			for (int i = 0; i < 4; i++) {
				int[][] new1 = copy(arr);
				watch(new1, i + 1, pos);
				watch(new1, (i + 1) % 4 + 1, pos);
				watch(new1, (i + 2) % 4 + 1, pos);
				newLi.add(new1);
			}
		}
		return newLi;
	}

	private static List<int[][]> c3(List<int[][]> li, int[] pos) {
		List<int[][]> newLi = new ArrayList<>();
		for (int[][] arr : li) {
			//좌상
			int[][] new1 = copy(arr);
			watch(new1, 3, pos);
			watch(new1, 1, pos);
			newLi.add(new1);
			//좌하
			int[][] new2 = copy(arr);
			watch(new2, 3, pos);
			watch(new2, 2, pos);
			newLi.add(new2);
			//하우
			int[][] new3 = copy(arr);
			watch(new3, 2, pos);
			watch(new3, 4, pos);
			newLi.add(new3);
			//우상
			int[][] new4 = copy(arr);
			watch(new4, 4, pos);
			watch(new4, 1, pos);
			newLi.add(new4);
		}
		return newLi;
	}

	private static List<int[][]> c2(List<int[][]> li, int[] pos) {
		List<int[][]> newLi = new ArrayList<>();
		for (int[][] arr : li) {
			//상하
			int[][] new1 = copy(arr);
			watch(new1, 1, pos);
			watch(new1, 2, pos);
			newLi.add(new1);
			//좌우
			int[][] new2 = copy(arr);
			watch(new2, 3, pos);
			watch(new2, 4, pos);
			newLi.add(new2);
		}
		return newLi;
	}

	private static List<int[][]> c1(List<int[][]> li, int[] pos) {

		List<int[][]> newLi = new ArrayList<>();
		for (int[][] arr : li) {
			for (int i = 0; i < 4; i++) {
				int[][] new1 = copy(arr);
				watch(new1, i + 1, pos);
				newLi.add(new1);
			}
		}
		return newLi;
	}

	private static void watch(int[][] arr, int dir, int[] pos) {
		// dir 1:상 2:하 3:좌 4:우
		int n = arr.length;
		int m = arr[0].length;
		switch (dir) {
			case 1 -> {
				for (int i = 0; i < n; i++) {
					int y = pos[0] - i;
					if (y >= 0 && y < n) {
						if (arr[y][pos[1]] == 6)
							break;
						else if (arr[y][pos[1]] > 0 && arr[y][pos[1]] < 6) {
							continue;
						} else {
							arr[y][pos[1]] = -1;
						}
					}
				}
			}

			case 2 -> {
				for (int i = 0; i < n; i++) {
					int y = pos[0] + i;
					if (y >= 0 && y < n) {
						if (arr[y][pos[1]] == 6)
							break;
						else if (arr[y][pos[1]] > 0 && arr[y][pos[1]] < 6) {
							continue;
						} else {
							arr[y][pos[1]] = -1;
						}
					}
				}
			}

			case 3 -> {
				for (int i = 0; i < m; i++) {
					int x = pos[1] - i;
					if (x >= 0 && x < m) {
						if (arr[pos[0]][x] == 6)
							break;
						else if (arr[pos[0]][x] > 0 && arr[pos[0]][x] < 6) {
							continue;
						} else {
							arr[pos[0]][x] = -1;
						}
					}
				}
			}

			case 4 -> {
				for (int i = 0; i < m; i++) {
					int x = pos[1] + i;
					if (x >= 0 && x < m) {
						if (arr[pos[0]][x] == 6)
							break;
						else if (arr[pos[0]][x] > 0 && arr[pos[0]][x] < 6) {
							continue;
						} else {
							arr[pos[0]][x] = -1;
						}
					}
				}
			}
		}
	}

	private static int[][] copy(int[][] arr) {

		int n = arr.length;
		int m = arr[0].length;
		int[][] newArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			newArr[i] = Arrays.copyOf(arr[i], m);
		}
		return newArr;
	}

	private static int count(int[][] arr) {
		int cnt = 0;
		int n = arr.length;
		int m = arr[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
