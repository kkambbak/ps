import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        //누적합 구하기
        for(int[] skill : skills){
            if(skill[0] == 1){
                sum[skill[1]][skill[2]] += 0-skill[5];
                sum[skill[3]+1][skill[4]+1] += 0-skill[5];
                sum[skill[1]][skill[4]+1] += skill[5];
                sum[skill[3]+1][skill[2]] += skill[5];
            }
            else{
                sum[skill[1]][skill[2]] += skill[5];
                sum[skill[3]+1][skill[4]+1] += skill[5];
                sum[skill[1]][skill[4]+1] += 0-skill[5];
                sum[skill[3]+1][skill[2]] += 0-skill[5];
            }
        }
        
        //왼 -> 오
        for(int i = 0; i < sum.length; i++){
            for(int j = 1; j < sum[0].length; j++){
                sum[i][j] += sum[i][j-1];
            }
            
        }
        
        //위 -> 아래
        for(int i = 1; i < sum.length; i++){
            for(int j = 0; j < sum[0].length; j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] += sum[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}