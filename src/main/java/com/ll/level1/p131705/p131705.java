package com.ll.level1.p131705;

import java.util.ArrayList;
import java.util.List;

public class p131705 {
    public static void main(String[] args) {
        int[] num = {-2, 3, 0, 2, -5};
        new Solution().solution(num);
    }
}

class Solution {
    public int solution(int[] number) {
        List<List<Integer>> result = getCombinations(number, 3);

        long l = result.stream().filter(i -> i.stream()
                .reduce(Integer::sum)
                .get().equals(0)
        ).count();
        return Long.valueOf(l).intValue();
    }

    List<List<Integer>> getCombinations(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(arr, r, 0, new ArrayList<>(), result);
        return result;
    }
    void generateCombinations(int[] arr, int r, int start, List<Integer> combination, List<List<Integer>> result) {
        if (r == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= arr.length - r; i++) {
            combination.add(arr[i]);
            generateCombinations(arr, r - 1, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
