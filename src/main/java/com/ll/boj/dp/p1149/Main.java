package com.ll.boj.dp.p1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] h = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				int c = Integer.parseInt(st.nextToken());
				h[i][j] = c;
			}
		}
		br.close();
		dp = new int[n + 1][3];

		new Main().solution(h, n);
	}

	private void solution(int[][] h, int n) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		dp[1][0] = h[1][0];
		dp[1][1] = h[1][1];
		dp[1][2] = h[1][2];

		for (int i = 2; i <= n; i++) {
			dp[i][0] = h[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = h[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = h[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
		}

		int answer = Arrays.stream(dp[n]).min().getAsInt();

		bw.write(String.valueOf(answer));

		bw.flush();
		bw.close();
	}
}