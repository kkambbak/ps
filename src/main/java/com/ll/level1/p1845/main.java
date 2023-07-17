package com.ll.level1.p1845;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class main {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};

		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int answer = Math.min(set.size(), nums.length/2);
	}
}
