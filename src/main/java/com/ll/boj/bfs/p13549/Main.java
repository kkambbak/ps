package com.ll.boj.bfs.p13549;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = new int[] {-1, 1};
	static int n;
	static int k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] field = new int[100001];
		Arrays.fill(field, -1);
		br.close();

		int answer = bfs(field);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	private static int bfs(int[] field) {

		Deque<Integer> dq = new LinkedList<>();
		dq.addLast(n);
		field[n] = 0;
		while (!dq.isEmpty()) {
			int poll = dq.poll();
			if (poll * 2 < 100001 && field[poll * 2] == -1) {
				field[poll * 2] = field[poll];
				dq.addFirst(2 * poll);
			}
			for (int i = 0; i < 2; i++) {
				int nx = poll + dx[i];
				if (nx < 0 || nx >= 100001 || field[nx] != -1)
					continue;
				field[nx] = field[poll] + 1;
				dq.addLast(nx);
			}
		}
		return field[k];
	}
}
