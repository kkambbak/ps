package com.ll.level0.p120812;

import java.util.*;

public class pr {
    public static void main(String[] args) {
        int[] array = {1};
        int answer = -1; // 최빈값이 없는 경우 -1을 할당

        HashMap<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        int maxIdx = -1;
        boolean isDuplicate = false;

        for(int i : array) {
            if (counts.containsKey(i)) {
                int count = counts.get(i) + 1;
                counts.put(i, count);
                if (count > maxCount) {
                    maxCount = count;
                    maxIdx = i;
                    isDuplicate = false;
                } else if (count == maxCount) {
                    isDuplicate = true;
                }
            } else {
                counts.put(i, 1);
                if (maxCount == 0) { // 최빈값이 없는 경우에는 첫 번째 값을 기본값으로 설정
                    maxCount = 1;
                    maxIdx = i;
                }
            }
        }

        if (!isDuplicate && maxCount > 1) { // 최빈값이 중복이 아니면서, 등장횟수가 1보다 큰 경우
            answer = maxIdx;
        }
        System.out.println(answer);
    }
}
