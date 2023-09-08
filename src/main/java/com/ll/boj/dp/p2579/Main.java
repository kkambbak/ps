package com.ll.boj.dp.p2579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] s = new int[n + 1];
		int t = 0;
		for (int i = 1; i <= n; i++) {
			s[i] = Integer.parseInt(br.readLine());
			t += s[i];
		}
		br.close();
		dp = new int[n + 1];

		new Main().solution(s, n, t);
	}

	public void solution(int[] s, int n, int t) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (n < 3) {
			bw.write(String.valueOf(t));
			bw.flush();
			bw.close();
			return;
		}
		dp[1] = s[1];
		dp[2] = s[2];
		dp[3] = s[3];

		for (int i = 4; i < n; i++) {
			dp[i] = Math.min(dp[i - 2], dp[i - 3]) + s[i];
		}
		int answer = t - Math.min(dp[n - 1], dp[n - 2]);
		bw.write(String.valueOf(answer));

		bw.flush();
		bw.close();
	}
}