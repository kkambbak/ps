package com.ll.boj.tp.p1806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		int end = 0;
		int sum = arr[0];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			while(end < n && sum < s) {
				end++;
				if(end != n) sum+=arr[end];
			}
			if(end == n) break;
			min = Math.min(min, end-i+1);
			sum -= arr[i];
		}

		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}
}