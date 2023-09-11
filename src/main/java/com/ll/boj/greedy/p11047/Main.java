package com.ll.boj.greedy.p11047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		int sum = 0;
		int idx = n-1;
		int cnt = 0;
		while(sum != k){
			if(c[idx] > k) idx--;
			while(sum + c[idx] <= k){
				sum += c[idx];
				cnt++;
			}
			idx--;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}