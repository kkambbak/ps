class Solution {
    
    int[] dy = new int[] {-1,-1,1,1};
    int[] dx = new int[] {-1,1,-1,1};
    int answer = 0;
    
    public int solution(int n) {
        
        int[][] board = new int[n][n];
        
        for(int i = 0; i < n; i++){
            board[0][i] = 1;
            recur(0, i, board);
            board[0][i] = 0;
        }
        
        return answer;
    }
    
    public void recur(int y, int x, int[][] board){
        if(y==board.length-1) {
            answer++;
            return;
        }        
        
        for(int i = 0; i < board.length; i++){
            if(check(y+1, i, board)){
                board[y+1][i] = 1;
                recur(y+1, i, board);
                board[y+1][i] = 0;
            }
            
        }
    }
    
    public boolean check(int y, int x, int[][] board){
        for(int i = 0; i < y; i++){
            if(board[i][x]==1) return false;
        }
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < board.length; j++){
                int ny = y + dy[i]*j;
                int nx = x + dx[i]*j;
                if(ny < 0 || nx < 0 || ny >= board.length || nx >= board.length) break;
                else if(board[ny][nx]==1) return false;
            }
        }
        
        return true;
    }
}