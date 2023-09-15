package com.ll.boj.simul.p18808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<int[][]> stickers = new ArrayList<>();
		int[][] notebook = new int[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[r][c];
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < c; l++) {
					sticker[j][l] = Integer.parseInt(st.nextToken());
				}
			}
			stickers.add(sticker);
		}
		br.close();

		for (int[][] sticker : stickers) {
			for (int i = 0; i < 4; i++) {
				if (!put(notebook, sticker, n, m))
					sticker = rotate(sticker);
				else {
					break;
				}
			}
		}
		int sum = Arrays.stream(notebook).mapToInt(i -> Arrays.stream(i).sum()).sum();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

	private static boolean put(int[][] notebook, int[][] sticker, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				//크기 체크
				if (n - i < sticker.length || m - j < sticker[0].length)
					continue;

				//겹침 체크
				if (checkDup(notebook, sticker, i, j))
					continue;

				putSticker(notebook, sticker, i, j);
				return true;

			}
		}
		return false;
	}

	private static void putSticker(int[][] notebook, int[][] sticker, int y1, int x1) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (sticker[i][j] == 1)
					notebook[y1 + i][x1 + j] = 1;
			}
		}
	}

	private static boolean checkDup(int[][] notebook, int[][] sticker, int y1, int x1) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (notebook[y1 + i][x1 + j] == 1 && sticker[i][j] == 1)
					return true;
			}
		}
		return false;
	}

	private static int[][] rotate(int[][] sticker) {
		int y = sticker.length;
		int x = sticker[0].length;
		int[][] newS = new int[x][y];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				newS[j][y - i - 1] = sticker[i][j];
			}
		}
		return newS;
	}
}