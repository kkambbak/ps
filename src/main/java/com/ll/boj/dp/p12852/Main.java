package com.ll.boj.dp.p12852;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		br.close();

		new Main().solution(x);
	}

	public void solution(int x) throws Exception {
		int[] arr = new int[x + 2];
		int[] pre = new int[x + 2];
		arr[1] = 0;

		for (int i = 2; i <= x; i++) {
			arr[i] = arr[i - 1] + 1;
			pre[i] = i - 1;
			if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
				arr[i] = arr[i / 2] + 1;
				pre[i] = i / 2;
			}
			if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
				arr[i] = arr[i / 3] + 1;
				pre[i] = i / 3;
			}
		}

		StringBuilder sb = new StringBuilder();
		int p = x;
		while (p != 0) {
			sb.append(p);
			sb.append(' ');
			p = pre[p];
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(arr[x]));
		bw.newLine();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}