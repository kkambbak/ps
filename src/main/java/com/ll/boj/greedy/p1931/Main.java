package com.ll.boj.greedy.p1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[][] c = new long[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			c[i][0] = Integer.parseInt(st.nextToken());
			c[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();

		new Main().solution(c, n);
	}

	private void solution(long[][] c, int n) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;

		long[][] a = Arrays.stream(c)
			.sorted(Comparator.comparingInt((long[] v) -> Math.toIntExact(v[1])).thenComparingInt(v -> Math.toIntExact(v[0])))
			.toArray(long[][]::new);

		long end = 0;
		for (int i = 0; i < n; i++) {
			if (a[i][0] < end) continue;
			answer++;
			end = a[i][1];
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}