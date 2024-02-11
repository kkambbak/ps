import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] weights = new int[n];
        int[] values = new int[n];

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weights[i] = w;
            values[i] = v;
        }
        int answer = knapsack(k, weights, values, n);

        System.out.println(answer);
    }
    public static int knapsack(int max, int[] weight, int[] value, int n) {
        int[][] dp = new int[n + 1][max + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= max; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][max];
    }
}
