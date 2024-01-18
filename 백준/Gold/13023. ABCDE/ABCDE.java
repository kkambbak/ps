import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {


    static int n;
    static int m;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        String s = "0";
        for (int i = 0; i < n; i++) {
            boolean[] booleans = new boolean[n];
            booleans[i] = true;
            if(dfs(i, booleans, 1)==1){
                s = "1";
                break;
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(s);
        bw.flush();
        bw.close();

    }

    private static int dfs(int a, boolean[] visited, int count) {

        if(count >= 5){
            return 1;
        }

        for(int i: arr[a]){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(i, visited, count+1)==1) return 1;
                visited[i] = false;
            }
        }

        return 0;
    }
}
