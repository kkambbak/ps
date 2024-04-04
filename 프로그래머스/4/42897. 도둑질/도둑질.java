import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];
        
        if(money.length ==3) {
            dp[2] = Math.max(Math.max(money[2], money[1]), money[0]);
            return dp[2];
        }
        
        dp[0] = 0;
        dp[1] = money[1];

        for(int i = 2; i < money.length; i++){
            dp[i] = Math.max(money[i] + dp[i-2], dp[i-1]);
        }

        money = Arrays.copyOfRange(money, 1, money.length);
        money[money.length-1] = 0;
        dp2[0] = money[0];
        dp2[1] = money[1];

        for(int i = 2; i < money.length; i++){
            dp2[i] = Math.max(money[i] + dp2[i-2], dp2[i-1]);
        }
         
        
        return Math.max(dp[money.length-1],dp2[money.length-1]);
    }
}