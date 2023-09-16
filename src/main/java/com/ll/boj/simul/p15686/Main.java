package com.ll.boj.simul.p15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<int[]>> combi = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];
		List<int[]> chickens = new ArrayList<>();
		List<int[]> homes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 1) {
					homes.add(new int[] {i, j});
				} else if (num == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}
		br.close();

		pickChickens(chickens, new boolean[chickens.size()], 0, 0, m);

		List<Integer> distSums = new ArrayList<>();
		for (List<int[]> li : combi) {
			int[] dists = new int[homes.size()];
			for (int[] chicken : li) {
				getDist(chicken, homes, dists);
			}
			int sum = 0;
			for (int dist : dists) {
				sum += dist;
			}
			distSums.add(sum);
		}

		int answer = distSums.stream().min(Integer::compareTo).get();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	private static void getDist(int[] chicken, List<int[]> homes, int[] dists) {
		int idx = 0;
		for (int[] home : homes) {
			int dist = Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1]);
			if (dists[idx] == 0)
				dists[idx] = dist;
			else
				dists[idx] = Math.min(dists[idx], dist);
			idx++;
		}
	}

	private static void pickChickens(List<int[]> chickens, boolean[] visited, int start, int depth, int r) {

		List<int[]> temp = new ArrayList<>();
		if (depth == r) {
			for (int i = 0; i < chickens.size(); i++) {
				if (visited[i]) {
					temp.add(chickens.get(i));
				}
			}
			combi.add(temp);
		}
		for (int i = start; i < chickens.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				pickChickens(chickens, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}
	}
}