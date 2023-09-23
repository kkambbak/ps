package com.ll.boj.tp.p2230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int end = 0;
		for (int i = 0; i < n-1; i++) {
			while(end < n && arr[end] - arr[i] < m) end++;
			if(end == n) break;
			min = Math.min(min, arr[end] - arr[i]);
		}
		System.out.println(min);
	}
}