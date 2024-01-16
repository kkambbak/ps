import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] u;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        u = new int[n][3];

        //초기화
        arr = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            arr[i] = i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(calc == 0){
                union(arr[a], arr[b]);
            } else {
                if(check(a,b)){
                    bw.write("YES");
                } else bw.write("NO");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();

    }

    public static void union(int a, int b){
        int ax = find(a);
        int bx = find(b);
        if(ax!=bx){
            if(ax < bx){
                arr[bx] = ax;
            }
            else arr[ax] = bx;
        }
    }

    public static int find(int a){
        if(a == arr[a]){
            return a;
        } else{
            return arr[a] = find(arr[a]);
        }
    }

    public static boolean check(int a, int b){
        if(find(a) == find(b)){
            return true;
        }
        else return false;
    }
}
