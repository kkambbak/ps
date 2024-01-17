import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] u;
    static HashSet<Integer>[] sets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        u = new int[n][2];

        sets = new HashSet[n+1];
        for (int i = 0; i <= n; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sets[a].add(b);
            sets[b].add(a);
        }
        int cnt = 0;
        HashSet<Integer> friends = new HashSet<>(sets[1]);
        for (int x : sets[1]) {
            friends.addAll(sets[x]);
        }
        friends.remove(1);
        cnt = friends.size();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

}
