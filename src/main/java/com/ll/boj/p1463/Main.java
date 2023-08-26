package com.ll.boj.p1463;

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
		arr[1] = 0;

		for (int i = 2; i <= x; i++) {
			arr[i] = arr[i - 1] + 1;
			if (i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			}
			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(arr[x]));
		bw.flush();
		bw.close();
	}
}