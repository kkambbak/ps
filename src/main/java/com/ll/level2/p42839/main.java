package com.ll.level2.p42839;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        new Solution().solution("1234");

    }
}
class Solution {
    public int solution(String numbers) {
        int answer = 0;

        int[] nums = IntStream.range(0, numbers.length())
                .map(i -> numbers.charAt(i) - '0')
                .toArray();
        System.out.println(Arrays.toString(nums));

        Combination combination = new Combination();
        int r = 2;
        combination.makeComb(nums, r);
        System.out.println(isPrime(171));
        return answer;
    }

    boolean isPrime(int n) {
        if(n<=1) return false;
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    class Combination {
        private static final int[] arr = {1, 2, 3, 4, 5, 6, 7};
        private static void recursion(int[] arr, int r, int index, List<Integer> tempList, List<List<Integer>> result) {
            if (tempList.size() == r) {
                result.add(new ArrayList<>(tempList));
                return;
            }

            if (index == arr.length) {
                return;
            }

            tempList.add(arr[index]);
            recursion(arr, r, index + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
            recursion(arr, r, index + 1, tempList, result);
        }

        public void makeComb(int[] arr,int r) {
            List<Integer> tempList = new ArrayList<>();
            List<List<Integer>> resultList = new ArrayList<>();
            recursion(arr, r, 0, tempList, resultList);
            System.out.println(resultList);
        }
    }
}

