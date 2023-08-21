package com.ll.level2.p86971;

import java.util.*;
import java.util.stream.*;

class Solution {
	public int solution(int n, int[][] wires) {
		int min = 101;

		for(int i = 0; i < wires.length; i++){
			final int num = i;
			int[][] unwires = IntStream.range(0, wires.length)
				.filter(w -> w != num)
				.mapToObj(w -> wires[w])
				.toArray(int[][]::new);
			min = Math.min(min, getDiff(unwires));
		}

		return min;
	}

	public Map<Integer,ArrayList<Integer>> makeMap(int[][] wires){

		Map<Integer,ArrayList<Integer>> map = new HashMap<>();

		for(int[] wire: wires){
			map.putIfAbsent(wire[0], new ArrayList<>());
			map.get(wire[0]).add(wire[1]);
			map.putIfAbsent(wire[1], new ArrayList<>());
			map.get(wire[1]).add(wire[0]);
		}
		return map;
	}

	public int getDiff(int[][] wires){

		boolean[] visited = new boolean[wires.length+3];

		Map<Integer,ArrayList<Integer>> map = makeMap(wires);

		Queue<Integer> que = new LinkedList<>();
		List<Integer> counts = new ArrayList<>();

		for(int i = 1; i <= wires.length+2; i++){
			if(visited[i]) continue;

			int count = 0;
			que.add(i);
			while(!que.isEmpty()){
				int poll = que.poll();
				if(!visited[poll]){
					count++;

					if(map.get(poll)==null) break;

					map.get(poll).forEach(x->que.add(x));
					visited[poll] = true;

				}
			}
			counts.add(count);
		}
		return Math.abs(counts.get(0) - counts.get(1));
	}
}
public class main {
}
