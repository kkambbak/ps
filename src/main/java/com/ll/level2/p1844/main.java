package com.ll.level2.p1844;
import java.util.*;
public class main {
    public static void main(String[] args) {
        new Solution().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
    }
}

class Solution {

    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }


    private int bfs(int[][] maps){
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();

        int newX;
        int newY;

        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){

            int[] pos = queue.poll();

            for(int i = 0; i < 4; i++){
                newX = pos[1]+dx[i];
                newY = pos[0]+dy[i];
                if (newX<0 || newX >= maps[0].length || newY<0 || newY >= maps.length )
                    continue;

                if(maps[newY][newX]==1){
                    maps[newY][newX]=maps[pos[0]][pos[1]] + 1;
                    queue.add(new int[]{newY, newX});
                }

            }

            if(pos[0]== maps.length-1 && pos[1]==maps[0].length-1)
                return maps[pos[0]][pos[1]];
        }
        return -1;
    }
}
