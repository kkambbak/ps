import java.util.*;

class Solution {
    public int solution(int[] money) {
        if(money.length == 1) return money[0];
        
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];

        // 첫 번째 집을 털지 않는 경우
        dp[0] = 0;
        dp[1] = money[1];
        for(int i = 2; i < money.length; i++){
            dp[i] = Math.max(money[i] + dp[i-2], dp[i-1]);
        }

        // 첫 번째 집을 털 경우
        dp2[0] = money[0];
        dp2[1] = Math.max(money[0], money[1]); // 첫 번째 집을 털었으므로 두 번째 집은 털 수 없음
        for(int i = 2; i < money.length - 1; i++){ // 마지막 집은 첫 번째 집을 털었으므로 털 수 없음
            dp2[i] = Math.max(money[i] + dp2[i-2], dp2[i-1]);
        }
        
        // 마지막 집을 고려하지 않는 dp2 배열에서는 마지막-1 집까지만 고려하므로, 마지막 값은 마지막-1 집의 값과 동일하게 설정
        dp2[money.length-1] = dp2[money.length-2];
        
        return Math.max(dp[money.length-1], dp2[money.length-1]);
    }
}
