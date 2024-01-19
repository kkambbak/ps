import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            int[][] arr = new int[m + 2][2];
            for (int j = 0; j < m + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[j][0] = x;
                arr[j][1] = y;

            }
            s = solution(arr);
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static String solution(int[][] arr) {
        int[] home = arr[0];
        int[] rock = arr[arr.length - 1];

        ArrayList[] adjList = make(arr, home, rock);
        return bfs(adjList);
    }

    private static String bfs(ArrayList[] adjList) {

        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);

        while(!que.isEmpty()){
            int poll = que.poll();
            if(visited[poll]) continue;
            visited[poll] = true;
            if(poll == adjList.length-1) return "happy";

            for (int i = 0; i < adjList[poll].size(); i++) {
                int nextNode = (int) adjList[poll].get(i);
                if(!visited[nextNode])
                    que.add(nextNode);
                
            }
        }
        return "sad";
    }

    private static ArrayList[] make(int[][] arr, int[] home, int[] rock) {
        ArrayList<Integer>[] adjList = new ArrayList[arr.length];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length; j++) {
                int dist = getDist(arr[i], arr[j]);
                if(dist <= 1000 && i!=j){
                    adjList[i].add(j);
                }
            }
        }

        return adjList;
    }

    private static int getDist(int[] a1, int[] a2) {
        return Math.abs(a1[0] - a2[0]) + Math.abs(a1[1] - a2[1]);
    }
}
