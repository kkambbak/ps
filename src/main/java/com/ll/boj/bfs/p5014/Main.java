package com.ll.boj.bfs.p5014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		final int[] dy = new int[] {u, -d};
		int[] building = new int[f+1];
		boolean[] check = new boolean[f + 1];

		Queue<Integer> que = new LinkedList<>();
		que.add(s);
		check[s] = true;
		while(!que.isEmpty()){
			Integer poll = que.poll();

			for (int i = 0; i < 2; i++) {
				int ny = poll + dy[i];
				if(ny < 1 || ny > f) continue;
				if(check[ny]) continue;
				building[ny] = building[poll] + 1;
				check[ny] = true;
				if(ny==g){
					break;
				}
				que.add(ny);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(g==s)
			bw.write(String.valueOf(0));
		else if(building[g] == 0)
			bw.write("use the stairs");
		else
			bw.write(String.valueOf(building[g]));
		bw.flush();
		bw.close();
	}
}