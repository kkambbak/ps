import java.util.*;

class Solution {
    int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        make(rows, columns);
        
        int idx = 0;
        for(int[] q: queries){
            answer[idx] = rotate(q);
            idx++;
        }
            
        return answer;
    }
    
    public int rotate(int[] q){
        int x1 = q[0];
        int y1 = q[1];
        int x2 = q[2];
        int y2 = q[3];
        
        int min = 999999;
        int last = board[x1-1][y1-1];
        for(int i=x1-1; i<x2-1; i++){
            board[i][y1-1] = board[i+1][y1-1];
            min = Math.min(min, board[i][y1-1]);
        }
        for(int i=y1-1; i<y2-1; i++){
            board[x2-1][i] = board[x2-1][i+1];
            min = Math.min(min, board[x2-1][i]);
        }
        for(int i=x2-1; i>x1-1; i--){
            board[i][y2-1] = board[i-1][y2-1];
            min = Math.min(min, board[i][y2-1]);
        }
        for(int i=y2-1; i>y1; i--){
            board[x1-1][i] = board[x1-1][i-1];
            min = Math.min(min, board[x1-1][i]);
        }
        board[x1-1][y1] = last;
        min = Math.min(min, board[x1-1][y1]);
        return min;
    }
    
    public void make(int r, int c){
        board = new int[r][c];
        int num = 1;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                board[i][j] = num;
                num++;
            }
        }
    }
    
    public void print(){
        System.out.println("----------------");
        for(int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}