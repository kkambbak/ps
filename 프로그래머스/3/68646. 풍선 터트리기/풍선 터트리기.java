import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        Set<Integer> set = new HashSet<>();
        set.add(a[0]);
        set.add(a[n-1]);
        for (int i = 1; i < n-1; i++) {
            if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                set.add(a[i]);
            }
        }

        answer = set.size();

        return answer;
    }
}