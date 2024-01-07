import java.util.*;

class Solution {
    
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    
    int yLen;
    int xLen;
    
    public int solution(String[] board) {
        // board파싱
        int[][] map = new int[board.length][board[0].length()];
        yLen = board.length;
        xLen = board[0].length();
    
        int idx = 0;
        int[] startPos = new int[2];
        int[] endPos = new int[2];
        for(String s: board){
            
            String[] split = s.split("");
            for(int i = 0; i < split.length; i++){
                switch(split[i]){
                        case "." -> map[idx][i] = 0;
                        case "D" -> map[idx][i] = -1;
                        case "G" -> {
                            map[idx][i] = -2;
                            endPos[0] = idx;
                            endPos[1] = i;
                        }
                        case "R" -> {
                            map[idx][i] = 0;
                            startPos[0] = idx;
                            startPos[1] = i;
                        }
                }
            }
            idx++;
        }
        
        //bfs
        int answer = bfs(startPos, map);
        
        return answer;
    }
    
    int bfs(int[] startPos, int[][] map){
        
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> que = new LinkedList<>();
        que.add(startPos);
        visited[startPos[0]][startPos[1]] = true;
        while(!que.isEmpty()){
            int[] poll = que.poll();
            for(int i = 0; i<4; i++){
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                
                if(!checkBoundary(ny,nx) && map[ny][nx] == -1) continue;
                
                while(!checkBoundary(ny + dy[i],nx + dx[i]) && map[ny + dy[i]][nx + dx[i]] != -1){
                    ny = ny + dy[i];
                    nx = nx + dx[i];
                }
                
                if(!checkBoundary(ny,nx) && !visited[ny][nx]) {
                    que.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    
                    if(map[ny][nx] == -2){
                        return map[poll[0]][poll[1]] + 1;
                    }
                    
                    map[ny][nx] = map[poll[0]][poll[1]] + 1;
                }
            }
        }
        return -1;
    }
    
    public boolean checkBoundary(int ny, int nx){
        return ny < 0 || nx < 0 || ny >= yLen || nx >= xLen;
    }
}