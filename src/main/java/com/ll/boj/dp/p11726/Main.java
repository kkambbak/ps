package com.ll.boj.dp.p11726;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		d = new int[n+1];
		new Main().solution(n);
	}

	private void solution(int n) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;

		d[1] = 1;
		if(n < 2){
			bw.write(String.valueOf(1));
			bw.flush();
			return;
		}
		d[2] = 2;

		for(int i = 3; i <= n; i++){
			d[i] = (d[i-1] + d[i-2]) % 10007;
		}
		answer = d[n];

		bw.write(String.valueOf(answer));

		bw.flush();
		bw.close();
	}
}
