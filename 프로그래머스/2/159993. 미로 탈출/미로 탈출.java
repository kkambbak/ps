import java.util.*;

class Solution {
    int[] dx = new int[] {0,0,-1,1};
    int[] dy = new int[] {-1,1,0,0};
    
    char[][] map;
    int[] start;
    int[] end;
    int[] lever;
    int[][] cnt;
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S')
                    start = new int[]{i,j};
                if(map[i][j]=='E')
                    end = new int[]{i,j};
                if(map[i][j]=='L')
                    lever = new int[]{i,j};
            }
        }               
        int[][] counts = new int[maps.length][maps[0].length()];
        cnt = new int[maps.length][maps[0].length()];
        bfs(start, lever, counts);
        //print(counts, counts.length);
        cnt[lever[0]][lever[1]] = counts[lever[0]][lever[1]];
        if(cnt[lever[0]][lever[1]] == 0) return -1;
        
        bfs(lever, end, cnt);
        //print(cnt, cnt.length);
        if(cnt[end[0]][end[1]] == 0) return -1;
        return cnt[end[0]][end[1]];
    }
    
    public void bfs(int[] start, int[] target, int[][] counts){
        
        Queue<int[]> que = new LinkedList<>(); 
        que.add(start);
        
        while(!que.isEmpty()){
            int[] poll = que.poll(); 
            for(int i = 0; i < 4; i++){
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                if(ny < 0 || ny >= counts.length || nx < 0 || nx >= counts[0].length) continue;
                if(map[ny][nx] == 'X' || counts[ny][nx] != 0) continue;

                counts[ny][nx] = counts[poll[0]][poll[1]] + 1;

                if(ny == target[0] && nx == target[1]) {
                    return;
                }
                
                que.add(new int[]{ny, nx});
            }
        }
    }
    
    public void print(int[][] arr, int n){
        System.out.println("-------------------");
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}