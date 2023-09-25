package com.ll.boj.tp.p1644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		List<Integer> li = findPrimes(n);

		int end = 0;
		int sum = li.get(0);
		int cnt = 0;
		final int s = li.size();
		for (int i = 0; i < s; i++) {
			while (end < s && sum < n) {
				end++;
				if (end != s)
					sum += li.get(end);
			}
			if (sum == n)
				cnt++;
			if (end == s)
				break;
			sum -= li.get(i);
		}

		System.out.println(cnt);
	}

	private static List<Integer> findPrimes(int n) {

		//1일 때 사실 0임.
		if(n==1) return List.of(2);

		List<Integer> primes = new ArrayList<>();
		boolean[] notPrime = new boolean[n + 1];

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!notPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					notPrime[j] = true;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (!notPrime[i]) {
				primes.add(i);
			}
		}

		return primes;
	}
}
