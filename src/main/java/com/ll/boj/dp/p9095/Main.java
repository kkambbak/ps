package com.ll.boj.dp.p9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		dp = new int[Arrays.stream(arr).max().getAsInt() + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		new Main().solution(arr);
	}

	public void solution(int[] arr) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int num : arr) {
			bw.write(String.valueOf(dp(num)));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	public int dp(int n) {
		if (dp[n] == 0) {
			dp[n] = dp(n - 3) + dp(n - 2) + dp(n - 1);
		}
		return dp[n];
	}
}