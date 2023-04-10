package com.ll.level2.p81302;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        new Solution().solution(new String[][]{{"OPOPX", "XXXXX", "XXXXX", "XXXXX", "XXXXX"},{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                ,{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                ,{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }
}
class Solution {
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];
        Arrays.fill(answer, 1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(places[i][j].charAt(k) == 'P'){
                        if(!check(i,j,k,places)){
                            answer[i]=0;
                            break;
                        }
                    }
                }
                if(answer[i]==0) break;
            }
        }


        System.out.println(Arrays.toString(answer));
        return answer;
    }

    boolean check(int num, int y, int x, String[][] places) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if(places[num][ny].charAt(nx)=='P')
                    return false;
                else if (places[num][ny].charAt(nx)=='O') {
                    for (int j = 0; j < 4; j++) {
                        int nx2 = nx + dx[j];
                        int ny2 = ny + dy[j];
                        if (nx2 >= 0 && nx2 < 5 && ny2 >= 0 && ny2 < 5){
                            if (ny2 == y && nx2 == x) {

                            } else if (places[num][ny2].charAt(nx2) == 'P') {
                                return false;
                            }
                        }

                    }
                }
            }

        }
        return true;
    }
}
