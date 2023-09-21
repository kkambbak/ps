package com.ll.boj.bfs.p9466;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


	static int[] state;
	static int[] students;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			students = new int[n+1];
			state = new int[n+1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j <= n; j++) {
				if (state[j] == 0)
					run(j);
			}

			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (state[j] != -1) cnt++;
			}

			bw.write(String.valueOf(cnt));
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static void run(final int start) {
		int cur = start;
		while(true){
			state[cur] = start;
			cur = students[cur];
			if (state[cur] == start) {
				while(state[cur] != -1){
					state[cur] = -1;
					cur = students[cur];
				}
				return;
			} else if (state[cur] != 0) {
				return;
			}
		}
	}
}