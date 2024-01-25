import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 최단거리 배열 초기화
        int[] dists = new int[N+1];
        Arrays.fill(dists, 9999999);
        dists[1] = 0;

        // 인접리스트로
        ArrayList<Edge>[] li = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            li[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++){
            li[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            li[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        
        boolean[] visited = new boolean[N+1];
        
        //다익스트라
        PriorityQueue<Edge> que = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        que.add(new Edge(1, 0));
        while(!que.isEmpty()){
            Edge e = que.poll();
            int poll = e.target;
            if(visited[poll]) continue;
            visited[poll] = true;
            for(Edge edge: li[poll]){
                dists[edge.target] = Math.min(dists[poll] + edge.w, dists[edge.target]);
                que.add(new Edge(edge.target, dists[edge.target]));
            }
        }

        answer = (int)Arrays.stream(dists).filter(i->i<=K).count();
        return answer;
    }
}

class Edge{
    int target;
    int w;
    
    public Edge(int target, int w){
        this.target = target;
        this.w = w;
    }
}